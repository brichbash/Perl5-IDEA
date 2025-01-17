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

package com.perl5.lang.perl.psi.stubs.subsdefinitions;

import com.intellij.psi.stubs.StubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.perl5.lang.perl.psi.PerlCallableElement;
import com.perl5.lang.perl.psi.stubs.PerlStubIndexBase;
import org.jetbrains.annotations.NotNull;


public class PerlCallableNamesIndex extends PerlStubIndexBase<PerlCallableElement> {
  public static final int VERSION = 0;
  public static final StubIndexKey<String, PerlCallableElement> KEY = StubIndexKey.createIndexKey("perl.callable.names");

  @Override
  public int getVersion() {
    return super.getVersion() + VERSION;
  }

  @Override
  public @NotNull StubIndexKey<String, PerlCallableElement> getKey() {
    return KEY;
  }

  @Override
  protected @NotNull Class<PerlCallableElement> getPsiClass() {
    return PerlCallableElement.class;
  }

  public static @NotNull PerlCallableNamesIndex getInstance() {
    return StubIndexExtension.EP_NAME.findExtensionOrFail(PerlCallableNamesIndex.class);
  }
}
