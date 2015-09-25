package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.shape.StrokeLineJoin;

public class JavaFXStrokeLineJoinConverter extends AbstractJavaFXFromStringConverter<StrokeLineJoin> {

	@Override
	public StrokeLineJoin getDefaultValue() {
            return StrokeLineJoin.ROUND;
	}

	@Override
	public Class<StrokeLineJoin> getTargetType() {
		return StrokeLineJoin.class;
	}

	@Override
	public StrokeLineJoin valueFromString(String constraint) {
		return StrokeLineJoin.valueOf(constraint);
	}

}