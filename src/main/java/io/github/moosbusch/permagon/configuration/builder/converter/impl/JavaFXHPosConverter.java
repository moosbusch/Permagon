package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.geometry.HPos;

public class JavaFXHPosConverter extends AbstractJavaFXFromStringConverter<HPos> {

	@Override
	public HPos getDefaultValue() {
            return HPos.CENTER;
	}

	@Override
	public Class<HPos> getTargetType() {
		return HPos.class;
	}

	@Override
	public HPos valueFromString(String constraint) {
		return HPos.valueOf(constraint);
	}

}