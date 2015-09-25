package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.input.TransferMode;

public class JavaFXTransferModeConverter extends AbstractJavaFXFromStringConverter<TransferMode> {

	@Override
	public TransferMode getDefaultValue() {
            return TransferMode.COPY;
	}

	@Override
	public Class<TransferMode> getTargetType() {
		return TransferMode.class;
	}

	@Override
	public TransferMode valueFromString(String constraint) {
		return TransferMode.valueOf(constraint);
	}

}