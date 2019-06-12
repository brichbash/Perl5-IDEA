/*
 * Copyright 2015-2019 Alexandr Evstigneev
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

package com.perl5.lang.perl.idea.configuration.module;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NotNullLazyValue;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.DirectoryProjectGeneratorBase;
import com.intellij.platform.ProjectGeneratorPeer;
import com.perl5.lang.perl.idea.modules.PerlModuleType;
import com.perl5.lang.perl.idea.project.PerlProjectManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PerlProjectGenerator extends DirectoryProjectGeneratorBase<PerlProjectGenerationSettings> {
  @NotNull
  @Override
  public String getName() {
    return PerlModuleType.getInstance().getName();
  }

  @Nullable
  @Override
  public Icon getLogo() {
    return PerlModuleType.getInstance().getIcon();
  }

  @NotNull
  @Override
  public NotNullLazyValue<ProjectGeneratorPeer<PerlProjectGenerationSettings>> createLazyPeer() {
    return NotNullLazyValue.createValue(this::createPeer);
  }

  @NotNull
  @Override
  public ProjectGeneratorPeer<PerlProjectGenerationSettings> createPeer() {
    return new PerlProjectGeneratorPeer();
  }

  @Override
  public void generateProject(@NotNull Project project,
                              @NotNull VirtualFile baseDir,
                              @NotNull PerlProjectGenerationSettings settings,
                              @NotNull Module module) {
    PerlProjectManager.getInstance(project).setProjectSdk(settings.getSdk());
  }
}
