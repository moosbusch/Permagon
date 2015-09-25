package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.effect.BlurType;

public class JavaFXBlurTypeConverter extends AbstractJavaFXFromStringConverter<BlurType> {

	@Override
	public BlurType getDefaultValue() {
            return BlurType.GAUSSIAN;
	}

	@Override
	public Class<BlurType> getTargetType() {
		return BlurType.class;
	}

	@Override
	public BlurType valueFromString(String constraint) {
		return BlurType.valueOf(constraint);
	}

}