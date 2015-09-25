package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.text.FontPosture;

public class JavaFXFontPostureConverter extends AbstractJavaFXFromStringConverter<FontPosture> {

    @Override
    public FontPosture getDefaultValue() {
        return FontPosture.REGULAR;
    }

    @Override
    public Class<FontPosture> getTargetType() {
        return FontPosture.class;
    }

    @Override
    public FontPosture valueFromString(String constraint) {
        return FontPosture.valueOf(constraint);
    }

}
