package com.visioninfinity.util;

import com.visioninfinity.model.Temperature;
import com.visioninfinity.model.TemperatureUnit;

/**
 * Helper class to convert temperature to desirable unit.
 * 
 * @author amit.x.sethi
 */
public class TemperatureConverter {

	/**
	 * Converts given temperature to from unit.
	 * 
	 * @param temperature - the input <code>Temperature</code> to convert.
	 * @param targetUnit - The <code>TemperatureUnit</code> to which the conversion is to be done.
	 * @return The converted <code>Temperature</code> to the provided <code>TemperatureUnit</code> targetUnit.
	 */
	public static Temperature convert(Temperature temperature, TemperatureUnit targetUnit) {
		switch (temperature.getUnit()) {
		case KELVIN:
			if (targetUnit == TemperatureUnit.FAHRENHEIT) {
				temperature.setValue(((temperature.getValue() - 273.15) * 1.8) + 32);
				temperature.setUnit(targetUnit);
			} else if (targetUnit == TemperatureUnit.CELCIUS) {
				temperature.setValue(temperature.getValue() - 273.15);
				temperature.setUnit(targetUnit);
			}
			break;
		case CELCIUS:
			if (targetUnit == TemperatureUnit.FAHRENHEIT) {
				temperature.setValue((temperature.getValue() * 1.8) + 32);
				temperature.setUnit(targetUnit);
			} else if (targetUnit == TemperatureUnit.KELVIN) {
				temperature.setValue(temperature.getValue() + 273.15);
				temperature.setUnit(targetUnit);
			}
			break;
		case FAHRENHEIT:
			if (targetUnit == TemperatureUnit.KELVIN) {
				temperature.setValue(273.15 + ((temperature.getValue() - 32) / 1.8));
				temperature.setUnit(targetUnit);
			} else if (targetUnit == TemperatureUnit.CELCIUS) {
				temperature.setValue((temperature.getValue() - 32) / 1.8);
				temperature.setUnit(targetUnit);
			}
			break;
		default:
			break;
		}
		return temperature;
	}
}
