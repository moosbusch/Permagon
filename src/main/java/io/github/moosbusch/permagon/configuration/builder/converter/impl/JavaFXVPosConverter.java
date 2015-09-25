package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.geometry.VPos;

public class JavaFXVPosConverter extends AbstractJavaFXFromStringConverter<VPos> {

	@Override
	public VPos getDefaultValue() {
            return VPos.BASELINE;
	}

	@Override
	public Class<VPos> getTargetType() {
		return VPos.class;
	}

	@Override
	public VPos valueFromString(String constraint) {
		return VPos.valueOf(constraint);
	}

}