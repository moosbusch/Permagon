package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.control.SelectionMode;

public class JavaFXSelectionModeConverter extends AbstractJavaFXFromStringConverter<SelectionMode> {

    @Override
    public SelectionMode getDefaultValue() {
        return SelectionMode.MULTIPLE;
    }

    @Override
    public Class<SelectionMode> getTargetType() {
        return SelectionMode.class;
    }

    @Override
    public SelectionMode valueFromString(String constraint) {
        return SelectionMode.valueOf(constraint);
    }

}
