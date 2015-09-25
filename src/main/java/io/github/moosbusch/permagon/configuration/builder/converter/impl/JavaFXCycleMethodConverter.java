package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.paint.CycleMethod;

public class JavaFXCycleMethodConverter extends AbstractJavaFXFromStringConverter<CycleMethod> {

	@Override
	public CycleMethod getDefaultValue() {
            return CycleMethod.NO_CYCLE;
	}

	@Override
	public Class<CycleMethod> getTargetType() {
		return CycleMethod.class;
	}

	@Override
	public CycleMethod valueFromString(String constraint) {
		return CycleMethod.valueOf(constraint);
	}

}