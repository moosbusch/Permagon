package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.control.Alert.AlertType;

public class JavaFXAlertTypeConverter extends AbstractJavaFXFromStringConverter<AlertType> {

	@Override
	public AlertType getDefaultValue() {
            return AlertType.NONE;
	}

	@Override
	public Class<AlertType> getTargetType() {
		return AlertType.class;
	}

	@Override
	public AlertType valueFromString(String constraint) {
		return AlertType.valueOf(constraint);
	}

}