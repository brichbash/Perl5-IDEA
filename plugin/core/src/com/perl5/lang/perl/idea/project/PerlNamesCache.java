/*
 * Copyright 2015-2020 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.idea.project;

import com.intellij.ProjectTopics;
import com.intellij.ide.lightEdit.LightEdit;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootEvent;
import com.intellij.openapi.roots.ModuleRootListener;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiTreeChangeAdapter;
import com.intellij.psi.PsiTreeChangeEvent;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.Processor;
import com.intellij.util.messages.MessageBusConnection;
import com.intellij.util.ui.update.MergingUpdateQueue;
import com.intellij.util.ui.update.Update;
import com.perl5.lang.perl.psi.PerlNamespaceDefinitionElement;
import com.perl5.lang.perl.psi.PerlSubDeclarationElement;
import com.perl5.lang.perl.psi.PerlSubDefinitionElement;
import com.perl5.lang.perl.psi.stubs.namespaces.PerlLightNamespaceIndex;
import com.perl5.lang.perl.psi.stubs.namespaces.PerlNamespaceIndex;
import com.perl5.lang.perl.psi.stubs.subsdeclarations.PerlSubDeclarationIndex;
import com.perl5.lang.perl.psi.stubs.subsdefinitions.PerlLightSubDefinitionsIndex;
import com.perl5.lang.perl.psi.stubs.subsdefinitions.PerlSubDefinitionsIndex;
import com.perl5.lang.perl.util.PerlPackageUtil;
import com.perl5.lang.perl.util.PerlTimeLogger;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;


public class PerlNamesCache implements Disposable {
  private static final Logger LOG = Logger.getInstance(PerlNamesCache.class);
  private final MergingUpdateQueue myQueue = new MergingUpdateQueue("Perl names cache updater", 1000, true, null, this, null, false);
  private final Project myProject;
  private final AtomicBoolean myIsUpdating = new AtomicBoolean(false);
  private volatile Set<String> myKnownSubs = Collections.emptySet();
  private volatile Set<String> myKnownNamespaces = Collections.emptySet();

  public PerlNamesCache(Project project) {
    myProject = project;
    if (LightEdit.owns(myProject)) {
      return;
    }
    MessageBusConnection connection = project.getMessageBus().connect(this);
    connection.subscribe(ProjectTopics.PROJECT_ROOTS, new ModuleRootListener() {
      @Override
      public void rootsChanged(@NotNull ModuleRootEvent event) {
        queueUpdate();
      }
    });
    connection.subscribe(DumbService.DUMB_MODE, new DumbService.DumbModeListener() {
      @Override
      public void exitDumbMode() {
        queueUpdate();
      }
    });
    PsiManager.getInstance(myProject).addPsiTreeChangeListener(new PsiTreeChangeAdapter() {
      @Override
      public void childAdded(@NotNull PsiTreeChangeEvent event) {
        queueUpdate();
      }

      @Override
      public void childRemoved(@NotNull PsiTreeChangeEvent event) {
        queueUpdate();
      }

      @Override
      public void childReplaced(@NotNull PsiTreeChangeEvent event) {
        queueUpdate();
      }

      @Override
      public void childMoved(@NotNull PsiTreeChangeEvent event) {
        queueUpdate();
      }

      @Override
      public void childrenChanged(@NotNull PsiTreeChangeEvent event) {
        queueUpdate();
      }

      @Override
      public void propertyChanged(@NotNull PsiTreeChangeEvent event) {
        queueUpdate();
      }
    }, this);
  }

  private void queueUpdate() {
    myQueue.queue(Update.create(this, this::doUpdateSingleThread));
  }

  private void doUpdateSingleThread() {
    if (myIsUpdating.compareAndSet(false, true)) {
      try {
        doUpdateCache();
      }
      finally {
        myIsUpdating.set(false);
      }
    }
    else {
      queueUpdate();
    }
  }

  private void doUpdateCache() {
    if (LightEdit.owns(myProject)) {
      return;
    }
    if (DumbService.isDumb(myProject)) {
      queueUpdate();
      return;
    }
    ReadAction.nonBlocking(() -> {
      PerlTimeLogger logger = PerlTimeLogger.create(LOG);
      logger.debug("Starting to update names cache at");
      Set<String> subsSet = new HashSet<>();

      GlobalSearchScope scope = GlobalSearchScope.allScope(myProject);
      Processor<PerlSubDeclarationElement> processor = it -> {
        subsSet.add(it.getCanonicalName());
        return false;
      };
      PerlSubDeclarationIndex subDeclarationIndex = PerlSubDeclarationIndex.getInstance();
      Collection<String> declarationsNames = subDeclarationIndex.getAllNames(myProject);
      logger.debug("Got declarations names: ", declarationsNames.size());
      for (String subName : declarationsNames) {
        ProgressManager.checkCanceled();
        subDeclarationIndex.processElements(myProject, subName, scope, processor);
      }
      logger.debug("Processed declarations");

      Processor<PerlSubDefinitionElement> perlSubDefinitionElementProcessor = it -> {
        subsSet.add(it.getCanonicalName());
        return false;
      };
      PerlSubDefinitionsIndex subDefinitionsIndex = PerlSubDefinitionsIndex.getInstance();
      Collection<String> definitionsNames = subDefinitionsIndex.getAllNames(myProject);
      logger.debug("Got definitions names: ", definitionsNames.size());
      for (String subName : definitionsNames) {
        ProgressManager.checkCanceled();
        subDefinitionsIndex.processElements(myProject, subName, scope, perlSubDefinitionElementProcessor);
      }
      logger.debug("Processed definitions");

      PerlLightSubDefinitionsIndex lightSubDefinitionsIndex = PerlLightSubDefinitionsIndex.getInstance();
      Collection<String> lightDefinitionsNames = lightSubDefinitionsIndex.getAllNames(myProject);
      logger.debug("Got light definitions names: ", lightDefinitionsNames.size());
      for (String subName : lightDefinitionsNames) {
        ProgressManager.checkCanceled();
        lightSubDefinitionsIndex.processLightElements(myProject, subName, scope, perlSubDefinitionElementProcessor);
      }
      logger.debug("Processed light definitions");
      myKnownSubs = Collections.unmodifiableSet(subsSet);

      Set<String> namespacesSet = new HashSet<>(PerlPackageUtil.CORE_PACKAGES_ALL);

      Processor<PerlNamespaceDefinitionElement> namespaceDefinitionElementProcessor = it -> {
        namespacesSet.add(it.getNamespaceName());
        return false;
      };
      PerlNamespaceIndex namespaceIndex = PerlNamespaceIndex.getInstance();
      Collection<String> namespacesNames = namespaceIndex.getAllNames(myProject);
      logger.debug("Got namespaces names: ", namespacesNames.size());
      for (String namespaceName : namespacesNames) {
        ProgressManager.checkCanceled();
        namespaceIndex.processElements(myProject, namespaceName, scope, namespaceDefinitionElementProcessor);
      }
      logger.debug("Processed namespaces");

      PerlLightNamespaceIndex lightNamespaceIndex = PerlLightNamespaceIndex.getInstance();
      Collection<String> lightNamespacesNames = lightNamespaceIndex.getAllNames(myProject);
      logger.debug("Got light namespaces names: ", lightNamespacesNames.size());
      for (String namespaceName : lightNamespacesNames) {
        ProgressManager.checkCanceled();
        lightNamespaceIndex.processLightElements(myProject, namespaceName, scope, namespaceDefinitionElementProcessor);
      }
      logger.debug("Processed light namespaces");

      myKnownNamespaces = Collections.unmodifiableSet(namespacesSet);

      logger.debug("Names cache updated");
    }).inSmartMode(myProject).expireWhen(myProject::isDisposed).executeSynchronously();
  }

  public void forceCacheUpdate() {
    doUpdateSingleThread();
  }

  @Override
  public void dispose() {
  }

  public Set<String> getSubsNamesSet() {
    return myKnownSubs;
  }

  public Set<String> getNamespacesNamesSet() {
    return myKnownNamespaces;
  }

  public static @NotNull PerlNamesCache getInstance(@NotNull Project project) {
    return project.getService(PerlNamesCache.class);
  }
}