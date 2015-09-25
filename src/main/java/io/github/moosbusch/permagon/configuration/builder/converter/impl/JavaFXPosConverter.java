package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.geometry.Pos;

public class JavaFXPosConverter extends AbstractJavaFXFromStringConverter<Pos> {

	@Override
	public Pos getDefaultValue() {
            return Pos.BASELINE_CENTER;
	}

	@Override
	public Class<Pos> getTargetType() {
		return Pos.class;
	}

	@Override
	public Pos valueFromString(String constraint) {
		return Pos.valueOf(constraint);
	}

}