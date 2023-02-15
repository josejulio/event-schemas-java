const {getOptionValues, javaOptions, JavaTargetLanguage} = require("quicktype-core") ;
const {JacksonRenderer} = require("quicktype-core/dist/language/Java");

class CloudEventJavaLanguage extends JavaTargetLanguage {
    constructor() {
        super('Java', ['Java'], 'java');
    }

    makeRenderer(renderContext, untypedOptionValues) {
        return new CloudEventJacksonRenderer(this, renderContext, getOptionValues(javaOptions, untypedOptionValues));
    }
}

class CloudEventJacksonRenderer extends JacksonRenderer {
    annotationsForAccessor(_c, _className, _propertyName, jsonName, p, _isSetter) {
        const annotations = super.annotationsForAccessor(_c, _className, _propertyName, jsonName, p, _isSetter);
        if (!_c.isNullable) {
            annotations.push('@JsonInclude(JsonInclude.Include.NON_NULL)');
        }

        return annotations;
    }
}

module.exports = {
    CloudEventJavaLanguage
};
