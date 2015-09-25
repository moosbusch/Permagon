package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.layout.BackgroundRepeat;

public class JavaFXBackgroundRepeatConverter extends AbstractJavaFXFromStringConverter<BackgroundRepeat> {

    @Override
    public BackgroundRepeat getDefaultValue() {
        return BackgroundRepeat.NO_REPEAT;
    }

    @Override
    public Class<BackgroundRepeat> getTargetType() {
        return BackgroundRepeat.class;
    }

    @Override
    public BackgroundRepeat valueFromString(String constraint) {
        return BackgroundRepeat.valueOf(constraint);
    }

}
