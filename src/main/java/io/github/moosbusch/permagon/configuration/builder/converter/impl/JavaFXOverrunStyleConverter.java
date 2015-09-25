package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.control.OverrunStyle;

public class JavaFXOverrunStyleConverter extends AbstractJavaFXFromStringConverter<OverrunStyle> {

	@Override
	public OverrunStyle getDefaultValue() {
            return OverrunStyle.ELLIPSIS;
	}

	@Override
	public Class<OverrunStyle> getTargetType() {
		return OverrunStyle.class;
	}

	@Override
	public OverrunStyle valueFromString(String constraint) {
		return OverrunStyle.valueOf(constraint);
	}

}