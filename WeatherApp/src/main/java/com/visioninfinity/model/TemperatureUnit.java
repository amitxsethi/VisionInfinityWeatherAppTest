package com.visioninfinity.model;

/**
 * Enumeration for Temperature units.
 * 
 * @author amit.x.sethi
 *
 */
public enum TemperatureUnit {
	CELCIUS("Celcius"), FAHRENHEIT("Fahrenheit"), KELVIN("Kelvin");

	private String display;

	private TemperatureUnit(String display) {
		this.display = display;
	}

	@Override
	public String toString() {
		return display;
	}
}
