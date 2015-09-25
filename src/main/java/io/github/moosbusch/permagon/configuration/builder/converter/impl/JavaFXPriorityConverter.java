package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.layout.Priority;

public class JavaFXPriorityConverter extends AbstractJavaFXFromStringConverter<Priority> {

	@Override
	public Priority getDefaultValue() {
            return Priority.SOMETIMES;
	}

	@Override
	public Class<Priority> getTargetType() {
		return Priority.class;
	}

	@Override
	public Priority valueFromString(String constraint) {
		return Priority.valueOf(constraint);
	}

}