package io.swagger.codegen.languages;

import io.swagger.codegen.*;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.BooleanProperty;
import io.swagger.models.properties.DateProperty;
import io.swagger.models.properties.DateTimeProperty;
import io.swagger.models.properties.DecimalProperty;
import io.swagger.models.properties.DoubleProperty;
import io.swagger.models.properties.FloatProperty;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.LongProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;

import java.io.File;
import java.util.*;

import org.apache.commons.lang.StringUtils;

public class CpprestClientCodegen extends DefaultCodegen implements CodegenConfig {
    protected String sourceFolder = "cpprestapi";
    protected Map<String, String> namespaces = new HashMap<String, String>();
    private Map<String, String> stdTypesInclude = new HashMap<String, String>();
    private Map<String, String> jsonTypeMapping = new HashMap<String, String>();
    private Map<String, String> typeFormatMapping = new HashMap<String, String>();

    private List<Object> postModels = new ArrayList<Object>();
    private Map<String, Object> postOperations = new HashMap<String, Object>();

    public class CustomProperty {
        public String jsonValueType;
        public String inner;
        public boolean isString = false;
    }
    public class CustomOperation {
        public String operation;
        public String execute;
        public String namespace;
    }

    public CpprestClientCodegen() {
        super();
        outputFolder = "generated-code/cpprestapi";
        modelTemplateFiles.put("model-header.mustache", ".h");
        modelTemplateFiles.put("model-body.mustache", ".cpp");
        apiTemplateFiles.put("requestapi-header.mustache", ".h");
        apiTemplateFiles.put("requestapi-body.mustache", ".cpp");
        templateDir = "cpprest";
        modelPackage = "";

        defaultIncludes = new HashSet<String>(
                Arrays.asList(
                        "short",
                        "int",
                        "long",
                        "double",
                        "float",
                        "bool")
        );

        languageSpecificPrimitives = new HashSet<String>(
                Arrays.asList(
                        "short",
                        "int",
                        "long",
                        "double",
                        "float",
                        "bool")
        );
        
        stdTypesInclude.put("utility::string_t", "cpprest/details/basic_types.h");
        stdTypesInclude.put("std::vector", "vector");
        stdTypesInclude.put("std::vector<char>", "vector");
        stdTypesInclude.put("std::map", "map");
        stdTypesInclude.put("Binary", "vector");
        stdTypesInclude.put("Date", "cpprest/asyncrt_utils.h");
        stdTypesInclude.put("DateTime", "cpprest/asyncrt_utils.h");

        /*enum value_type
        {
            /// Number value
            Number,
            /// Boolean value
            Boolean,
            /// String value
            String,
            /// Object value
            Object,
            /// Array value
            Array,
            /// Null value
            Null
        };*/

        jsonTypeMapping.put("int", "web::json::value::number");
        jsonTypeMapping.put("int32_t", "web::json::value::number");
        jsonTypeMapping.put("int64_t", "web::json::value::number");
        jsonTypeMapping.put("long", "web::json::value::number");
        jsonTypeMapping.put("double", "web::json::value::number");
        jsonTypeMapping.put("float", "web::json::value::number");
        jsonTypeMapping.put("bool", "web::json::value::boolean");
        jsonTypeMapping.put("Date", "web::json::value::string");
        jsonTypeMapping.put("DateTime", "web::json::value::string");
        jsonTypeMapping.put("std::string", "web::json::value::string");
        jsonTypeMapping.put("utility::string_t", "web::json::value::string");
        jsonTypeMapping.put("std::vector", "web::json::value::array");

        typeFormatMapping.put("byte", "std::string");
        typeFormatMapping.put("binary", "std::vector<char>");
        typeFormatMapping.put("date", "utility::datetime");
        typeFormatMapping.put("date-time", "utility::datetime");

        reservedWords = new HashSet<String>(
                // According to http://en.cppreference.com/w/cpp/keyword and http://en.cppreference.com/w/c/keyword
                Arrays.asList(
                        "alignas", "alignof", "and", "and_eq", "asm", "auto", 
                        "bitand", "bitor", "bool", "break", "case", "catch", 
                        "char", "char16_t", "char32_t", "class", "compl", 
                        "concept", "const", "constexpr", "const_cast", "continue", 
                        "decltype", "default", "define", "defined", "delete", "do", "double", 
                        "dynamic_cast", "elif", "else", "endif", "enum", "error", "explicit", "export", 
                        "extern", "false", "final", "float", "for", "friend", "goto", "if", "ifdef", "ifndef",  
                        "include", "inline", "int", "line", "long", "mutable", "namespace", "new", 
                        "noexcept", "not", "not_eq", "nullptr", "operator", "or", 
                        "or_eq", "override", "pragma", "private", "protected", "public", "register", 
                        "reinterpret_cast", "requires", "restrict", "return", "short", "signed", 
                        "sizeof", "static", "static_assert", "static_cast", "struct", 
                        "switch", "template", "this", "thread_local", "throw", "true", 
                        "try", "typedef", "typeid", "typename", "undef", "union", "unsigned", 
                        "using", "virtual", "void", "volatile", "wchar_t", "while", 
                        "xor", "xor_eq", "_Alignas", "_Alignof", "_Atomic", "_Bool", "_Complex", 
                        "_Generic", "_Imaginary", "_Noreturn", "_Pragma", "_Static_assert", "_Thread_local"));

        super.typeMapping = new HashMap<String, String>();
        typeMapping.put("ByteArray", "std::vector<char>");
        typeMapping.put("Binary", "std::vector<char>");
        typeMapping.put("integer", "int");
        typeMapping.put("number", "long long");
        typeMapping.put("string", "utility::string_t");
        typeMapping.put("boolean", "bool");
        typeMapping.put("array", "std::vector");

        importMapping = new HashMap<String, String>();

        namespaces = new HashMap<String, String>();

        supportingFiles.clear();
        supportingFiles.add(new SupportingFile("httpmanager-header.mustache", sourceFolder, "HttpManager.h"));
        supportingFiles.add(new SupportingFile("httpmanager-body.mustache", sourceFolder, "HttpManager.cpp"));
        supportingFiles.add(new SupportingFile("modelobject-header.mustache", sourceFolder, "ModelObject.h"));
        supportingFiles.add(new SupportingFile("modelobject-body.mustache", sourceFolder, "ModelObject.cpp"));
        supportingFiles.add(new SupportingFile("requestobject-header.mustache", sourceFolder, "RequestObject.h"));
        supportingFiles.add(new SupportingFile("requestobject-body.mustache", sourceFolder, "RequestObject.cpp"));
    }

    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    public String getName() {
        return "cpprest";
    }

    public String getHelp() {
        return "Generates a Casablanca cpprest C++ client library.";
    }

    @Override
    public String toInstantiationType(Property p) {
        if (p instanceof MapProperty) {
            MapProperty ap = (MapProperty) p;
            String inner = getSwaggerType(ap.getAdditionalProperties());
            return instantiationTypes.get("map");
        } else if (p instanceof ArrayProperty) {
            ArrayProperty ap = (ArrayProperty) p;
            String inner = getSwaggerType(ap.getItems());
            return instantiationTypes.get("array");
        } else {
            return null;
        }
    }

    @Override
    public String getTypeDeclaration(String name) {
        if (languageSpecificPrimitives.contains(name)) {
            return name;
        } else {
            return "std::shared_ptr<model::" + name + ">";
        }
    }

    @Override
    public String getSwaggerType(Property p) {
        String swaggerType = super.getSwaggerType(p);
        String type = null;
        if (typeMapping.containsKey(swaggerType)) {
            type = typeMapping.get(swaggerType);
            if (languageSpecificPrimitives.contains(type)) {
                return toModelName(type);
            }
        } else {
            type = swaggerType;
        }
        return toModelName(type);
    }

    @Override
    public String getTypeDeclaration(Property p) {
        String swaggerType = getSwaggerType(p);
        if (p instanceof ArrayProperty) {
            ArrayProperty ap = (ArrayProperty) p;
            Property inner = ap.getItems();
            return getSwaggerType(p) + "<" + getTypeDeclaration(inner) + ">";
        } else if (p instanceof MapProperty) {
            MapProperty mp = (MapProperty) p;
            Property inner = mp.getAdditionalProperties();

            return getSwaggerType(p) + "<utility::string_t, " + getTypeDeclaration(inner) + ">";
        } else if (languageSpecificPrimitives.contains(swaggerType)) {
            return toModelName(swaggerType);
        } else if (stdTypesInclude.containsKey(swaggerType)) {
            if (p.getFormat() != null && typeFormatMapping.containsKey(p.getFormat())) {
                return typeFormatMapping.get(p.getFormat());
            } else {
                return swaggerType;
            }
        } else {
            if (p.getFormat() != null && typeFormatMapping.containsKey(p.getFormat())) {
                return typeFormatMapping.get(p.getFormat());
            } else {
                return "std::shared_ptr<model::" + swaggerType + ">";
            }
        }
    }

    @Override
    public String toModelName(String type) {
        if (typeMapping.keySet().contains(type) ||
                typeMapping.values().contains(type) ||
                importMapping.values().contains(type) ||
                defaultIncludes.contains(type) ||
                languageSpecificPrimitives.contains(type)) {
            return type;
        } else {
            return Character.toUpperCase(type.charAt(0)) + type.substring(1);
        }
    }

    @Override
    public Map<String, Object> postProcessModels(Map<String, Object> objs) {
        List<Object> models = (List<Object>) objs.get("models");
        postModels.addAll(models);
        for (Object _mo : models) {
            Map<String, Object> mo = (Map<String, Object>) _mo;
            CodegenModel cm = (CodegenModel) mo.get("model");
            for (CodegenProperty var : cm.vars) {
                CustomProperty customProperty = new CustomProperty();
                if (jsonTypeMapping.containsKey(var.baseType)) {
                    customProperty.jsonValueType = jsonTypeMapping.get(var.baseType);
                    if (var.isContainer != null && var.isContainer == true) {
                        customProperty.inner = "std::shared_ptr<" + var.complexType + ">";
                    }
                }
                if (var.datatype.equals("utility::string_t")) {
                    customProperty.isString = true;
                }
                var.customObject = customProperty;
            }
        }
        return objs;
    }

    @Override
    public Map<String, Object> postProcessOperations(Map<String, Object> objs) {
        Map<String, Object> operations = (Map<String, Object>) objs.get("operations");


        HashMap<String, Object> pathPrefixes = new HashMap<String, Object>();
        String pathPrefix = (String)operations.get("pathPrefix");
        List<CodegenOperation> ops = (List<CodegenOperation>)operations.get("operation");
        for (CodegenOperation op: ops) {
            CustomOperation custom = new CustomOperation();
            custom.operation = initialCaps(op.nickname);
            custom.execute = "execute";
            custom.namespace = op.baseName.toLowerCase();
            op.customObject = custom;
        }
        pathPrefixes.putAll(operations);
        postOperations.put(pathPrefix, operations);
        return super.postProcessOperations(objs);
    }

    @Override
    public Map<String, Object> postProcessSupportingFileData(Map<String, Object> objs) {
        objs.put("models", postModels);
        Set<Map.Entry<String, Object>> entrySet = postOperations.entrySet();
        objs.put("operations", entrySet);
        return super.postProcessSupportingFileData(objs);
    }

    @Override
    public String toModelImport(String name) {
        if (stdTypesInclude.containsKey(name)) {
            return "#include <" + stdTypesInclude.get(name) + ">";
        }
        return "#include \"" + name + ".h\"";
    }

    @Override
    public String toDefaultValue(Property p) {
        if (p instanceof StringProperty) {
            return "utility::string_t()";
        } else if (p instanceof BooleanProperty) {
            return "false";
        } else if (p instanceof DateProperty) {
            return "utility::datetime()";
        } else if (p instanceof DateTimeProperty) {
            return "utility::datetime()";
        } else if (p instanceof DoubleProperty) {
            return "0d";
        } else if (p instanceof FloatProperty) {
            return "0f";
        } else if (p instanceof IntegerProperty) {
            return "0";
        } else if (p instanceof LongProperty) {
            return "0l";
        } else if (p instanceof DecimalProperty) {
            return "0l";
        } else if (p instanceof MapProperty) {
            MapProperty ap = (MapProperty) p;
            String inner = getSwaggerType(ap.getAdditionalProperties());
            return "std::map<utility::string_t, " + inner + ">();";
        } else if (p instanceof ArrayProperty) {
            ArrayProperty ap = (ArrayProperty) p;
            String inner = getSwaggerType(ap.getItems());
            return "std::vector<" + inner + ">();";
        }
        // else
        if (p instanceof RefProperty) {
            RefProperty rp = (RefProperty) p;
            return "new " + toModelName(rp.getSimpleRef()) + "()";
        }
        return "null";
    }

    @Override
    public String apiFileFolder() {
        return outputFolder + File.separator + sourceFolder;
    }

    @Override
    public String modelFileFolder() {
        return outputFolder + File.separator + sourceFolder;
    }

    @Override
    public String toModelFilename(String name) {
        return initialCaps(name);
    }

    @Override
    public String toApiName(String name) {
        return initialCaps(name) + "Request";
    }

    public String toApiFilename(String name) {
        return initialCaps(name) + "Request";
    }

    @Override
    public String toVarName(String name) {
        String paramName = name.replaceAll("[^a-zA-Z0-9_]", "");
        return paramName;
    }

    public String escapeReservedWord(String name) {
        return "_" + name;
    }

    @Override
    public String toOperationId(String operationId) {
        // throw exception if method name is empty
        if (StringUtils.isEmpty(operationId)) {
            throw new RuntimeException("Empty method name (operationId) not allowed");
        }

        // method name cannot use reserved keyword, e.g. return$
        if (reservedWords.contains(operationId)) {
            throw new RuntimeException(operationId + " (reserved word) cannot be used as method name");
        }

        // add_pet_by_id => addPetById
        return camelize(operationId, true);
    }

}
