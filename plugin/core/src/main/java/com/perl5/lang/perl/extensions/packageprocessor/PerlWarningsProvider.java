/*
 * Copyright 2015-2022 Alexandr Evstigneev
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

package com.perl5.lang.perl.extensions.packageprocessor;

import com.perl5.lang.perl.internals.PerlWarningsMask;
import com.perl5.lang.perl.psi.impl.PerlUseStatementElement;
import org.jetbrains.annotations.NotNull;

/**
 * Marks package processor that it can modify ${^WARNING_BITS} (see use warnings)
 */
public interface PerlWarningsProvider {
  /**
   * Adjusts current mask with values, according to package import settings
   *
   * @param currentMask mask of the outer block, or null if there is no outer block
   * @return modified mask
   */
  default PerlWarningsMask getWarningMask(@NotNull PerlUseStatementElement useStatement, @NotNull PerlWarningsMask currentMask) {
    // fixme NYI
    return currentMask.clone();
  }

  /**
   * @return true iff we have warnings enabled by the {@code useStatement}
   */
  default boolean isWarningsEnabled(@NotNull PerlUseStatementElement useStatement) {
    return true;
  }
}
