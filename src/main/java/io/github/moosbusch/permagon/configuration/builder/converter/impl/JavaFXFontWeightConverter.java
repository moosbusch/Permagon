package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.text.FontWeight;

public class JavaFXFontWeightConverter extends AbstractJavaFXFromStringConverter<FontWeight> {

	@Override
	public FontWeight getDefaultValue() {
            return FontWeight.NORMAL;
	}

	@Override
	public Class<FontWeight> getTargetType() {
		return FontWeight.class;
	}

	@Override
	public FontWeight valueFromString(String constraint) {
		return FontWeight.valueOf(constraint);
	}

}