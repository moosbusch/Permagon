package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.text.TextBoundsType;

public class JavaFXTextBoundsTypeConverter extends AbstractJavaFXFromStringConverter<TextBoundsType> {

	@Override
	public TextBoundsType getDefaultValue() {
            return TextBoundsType.VISUAL;
	}

	@Override
	public Class<TextBoundsType> getTargetType() {
		return TextBoundsType.class;
	}

	@Override
	public TextBoundsType valueFromString(String constraint) {
		return TextBoundsType.valueOf(constraint);
	}

}