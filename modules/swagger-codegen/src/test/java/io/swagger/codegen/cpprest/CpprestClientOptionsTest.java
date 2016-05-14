package io.swagger.codegen.cpprest;

import io.swagger.codegen.AbstractOptionsTest;
import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.languages.CpprestClientCodegen;
import io.swagger.codegen.options.CpprestClientOptionsProvider;

import mockit.Expectations;
import mockit.Tested;

public class CpprestClientOptionsTest extends AbstractOptionsTest {

    @Tested
    private CpprestClientCodegen clientCodegen;

    public CpprestClientOptionsTest() {
        super(new CpprestClientOptionsProvider());
    }

    @Override
    protected CodegenConfig getCodegenConfig() {
        return clientCodegen;
    }

    @Override
    protected void setExpectations() {
        new Expectations(clientCodegen) {{
            clientCodegen.setSortParamsByRequiredFlag(Boolean.valueOf(CpprestClientOptionsProvider.SORT_PARAMS_VALUE));
            times = 1;
        }};
    }
}
