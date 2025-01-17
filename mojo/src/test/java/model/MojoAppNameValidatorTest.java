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

package model;

import base.MojoLightTestCase;
import com.intellij.openapi.ui.InputValidator;
import com.perl5.lang.mojolicious.model.MojoApp;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public class MojoAppNameValidatorTest extends MojoLightTestCase {
  @Override
  protected @NotNull InputValidator getValidator() {
    return new MojoApp.NameValidator();
  }

  @Test
  public void testLowercase() {
    assertNameInvalid("foo");
  }

  @Test
  public void testUppercase() {
    assertNameValid("FOO");
  }

  @Test
  public void testSingleLetter() {
    assertNameInvalid("F");
  }

  @Test
  public void testTwoLetters() {
    assertNameValid("Fo");
  }

  @Test
  public void testSnakeCase() {
    assertNameInvalid("foo_bar");
  }

  @Test
  public void testCamelcase() {
    assertNameValid("FooBar");
  }

  @Test
  public void testPackage() {
    assertNameValid("Foo::Bar");
  }

  @Test
  public void testSpace() {
    assertNameInvalid("Foo Bar");
  }

  @Test
  public void testPackageLowerSecond() {
    assertNameValid("Foo::bar");
  }
}
