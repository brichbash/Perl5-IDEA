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

package com.perl5.lang.perl.psi;

import com.intellij.psi.PsiElement;
import com.perl5.lang.perl.psi.mixins.PerlCallArgumentsMixin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Represents {@code unshift} and {@code push} expressions common logic
 */
public interface PerlUnshiftPushExpr extends PsiPerlExpr {
  /**
   * @return element representing target of this operation, first argument
   */
  @Nullable
  default PsiElement getTarget() {
    PsiPerlCallArguments callArguments = getCallArguments();
    if (callArguments == null) {
      return null;
    }
    List<PsiElement> argumentsList = ((PerlCallArgumentsMixin)callArguments).getArgumentsList();
    return argumentsList.isEmpty() ? null : argumentsList.get(0);
  }

  /**
   * @return list of elements to push or unshift to the {@link #getTarget() target}
   */
  @NotNull
  default List<PsiElement> getModification() {
    PsiPerlCallArguments callArguments = getCallArguments();
    if (callArguments == null) {
      return Collections.emptyList();
    }
    List<PsiElement> argumentsList = ((PerlCallArgumentsMixin)callArguments).getArgumentsList();
    if (argumentsList.size() < 2) {
      return Collections.emptyList();
    }
    return argumentsList.subList(1, argumentsList.size());
  }

  @Nullable
  PsiPerlCallArguments getCallArguments();
}
