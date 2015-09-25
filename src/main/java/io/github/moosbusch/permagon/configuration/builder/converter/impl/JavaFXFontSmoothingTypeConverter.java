package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.text.FontSmoothingType;

public class JavaFXFontSmoothingTypeConverter extends AbstractJavaFXFromStringConverter<FontSmoothingType> {

	@Override
	public FontSmoothingType getDefaultValue() {
            return FontSmoothingType.GRAY;
	}

	@Override
	public Class<FontSmoothingType> getTargetType() {
		return FontSmoothingType.class;
	}

	@Override
	public FontSmoothingType valueFromString(String constraint) {
		return FontSmoothingType.valueOf(constraint);
	}

}