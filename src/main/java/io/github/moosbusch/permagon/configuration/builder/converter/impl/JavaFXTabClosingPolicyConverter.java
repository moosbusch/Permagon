package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class JavaFXTabClosingPolicyConverter extends AbstractJavaFXFromStringConverter<TabClosingPolicy> {

	@Override
	public TabClosingPolicy getDefaultValue() {
            return TabClosingPolicy.UNAVAILABLE;
	}

	@Override
	public Class<TabClosingPolicy> getTargetType() {
		return TabClosingPolicy.class;
	}

	@Override
	public TabClosingPolicy valueFromString(String constraint) {
		return TabClosingPolicy.valueOf(constraint);
	}

}