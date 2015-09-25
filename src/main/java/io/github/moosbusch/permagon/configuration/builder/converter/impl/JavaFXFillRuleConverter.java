package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.shape.FillRule;

public class JavaFXFillRuleConverter extends AbstractJavaFXFromStringConverter<FillRule> {

    @Override
    public FillRule getDefaultValue() {
        return FillRule.EVEN_ODD;
    }

    @Override
    public Class<FillRule> getTargetType() {
        return FillRule.class;
    }

    @Override
    public FillRule valueFromString(String constraint) {
        return FillRule.valueOf(constraint);
    }

}
