package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.stage.Modality;

public class JavaFXModalityConverter extends AbstractJavaFXFromStringConverter<Modality> {

    @Override
    public Modality getDefaultValue() {
        return Modality.NONE;
    }

    @Override
    public Class<Modality> getTargetType() {
        return Modality.class;
    }

    @Override
    public Modality valueFromString(String constraint) {
        return Modality.valueOf(constraint);
    }

}
