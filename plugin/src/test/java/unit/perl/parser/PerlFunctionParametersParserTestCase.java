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

package unit.perl.parser;


import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public abstract class PerlFunctionParametersParserTestCase extends PerlParserTestBase {
  @Override
  protected final String getBaseDataPath() {
    return "unit/perl/parser/functionParameters/" + getDataDirName();
  }

  protected abstract @NotNull String getDataDirName();

  @Test
  public void testJoined() {doTest(false);}

  @Test
  public void testOmited() {doTest();}

  @Test
  public void testOmitedArray() {doTest();}

  @Test
  public void testTyped() {doTest();}

  @Test
  public void testTypedWithVars() {doTest();}

  @Test
  public void testAttrs() {doTest();}

  @Test
  public void testAttrsPrototype() {doTest();}

  @Test
  public void testDefaultArgs() {doTest();}

  @Test
  public void testDefaultCode() {doTest();}

  @Test
  public void testDefaultEmpty() {doTest();}

  @Test
  public void testDefaultUndef() {doTest();}

  @Test
  public void testDefaultUsePreceding() {doTest();}

  @Test
  public void testNamed() {doTest();}

  @Test
  public void testNamedDefault() {doTest();}

  @Test
  public void testPositionalAndNamed() {doTest();}

  @Test
  public void testSlurpy() {doTest();}

  @Test
  public void testEmptySignature() {doTest();}

  @Test
  public void testSimpleSignature() {doTest();}

  @Test
  public void testNoSignature() {doTest();}

  @Test
  public void testNoSignatureAttrs() {doTest(false);}

  @Test
  public void testInvocant() {doTest();}

  @Test
  public void testInvocantWithNamed() {doTest();}

  @Test
  public void testInvocantWithPositional() {doTest();}

  @Test
  public void testInvocantWithPositionalNamed() {doTest();}

  public static class AfterTest extends PerlFunctionParametersParserTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "after";
    }
  }

  public static class AroundTest extends PerlFunctionParametersParserTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "around";
    }
  }

  public static class AugmentTest extends PerlFunctionParametersParserTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "augment";
    }
  }

  public static class BeforeTest extends PerlFunctionParametersParserTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "before";
    }
  }

  public abstract static class FunctionTestCase extends PerlFunctionParametersParserTestCase {
    @Override
    @Test
    public void testInvocant() {doTest(false);}

    @Override
    @Test
    public void testInvocantWithNamed() {doTest(false);}

    @Override
    @Test
    public void testInvocantWithPositional() {doTest(false);}

    @Override
    @Test
    public void testInvocantWithPositionalNamed() {doTest(false);}
  }

  public static class FunctionTest extends FunctionTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "fun";
    }
  }

  public static class FunctionAnonTest extends FunctionTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "funAnon";
    }
  }

  public static class MethodAnonTest extends FunctionTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "methodAnon";
    }
  }

  public static class MethodTest extends PerlFunctionParametersParserTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "method";
    }

    @Override
    @Test
    public void testNoSignatureAttrs() {doTest();}
  }

  public static class OverrideTest extends PerlFunctionParametersParserTestCase {
    @Override
    protected @NotNull String getDataDirName() {
      return "override";
    }
  }
}
