package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.text.TextAlignment;

public class JavaFXTextAlignmentConverter extends AbstractJavaFXFromStringConverter<TextAlignment> {

	@Override
	public TextAlignment getDefaultValue() {
            return TextAlignment.LEFT;
	}

	@Override
	public Class<TextAlignment> getTargetType() {
		return TextAlignment.class;
	}

	@Override
	public TextAlignment valueFromString(String constraint) {
		return TextAlignment.valueOf(constraint);
	}

}