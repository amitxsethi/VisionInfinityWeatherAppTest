package com.visioninfinity.test;

import java.text.DecimalFormat;

import org.junit.Assert;
import org.junit.Test;

import com.visioninfinity.model.Temperature;
import com.visioninfinity.model.TemperatureUnit;
import com.visioninfinity.util.TemperatureConverter;

/**
 * Junit test class for TemperatureConverter.
 * 
 * @author amit.x.sethi
 */
public class TemperatureConverterTest {

	DecimalFormat temperatureFormatter = new DecimalFormat("#.0");

	/**
	 * Test for Celcius to Fahrenheit conversion
	 */
	@Test
	public void testC2FConversion() {
		Temperature input = new Temperature(20.5, TemperatureUnit.CELCIUS);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.FAHRENHEIT);
		Temperature expected = new Temperature(68.9, TemperatureUnit.FAHRENHEIT);
		assertValues(output, expected);
	}

	/**
	 * Test for Fahrenheit to Cencius conversion.
	 */
	@Test
	public void testF2CConversion() {
		Temperature input = new Temperature(68.9, TemperatureUnit.FAHRENHEIT);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.CELCIUS);
		Temperature expected = new Temperature(20.5, TemperatureUnit.CELCIUS);
		assertValues(output, expected);
	}

	/**
	 * Test for Cencius to Kelvin conversion.
	 */
	@Test
	public void testC2KConversion() {
		Temperature input = new Temperature(20.5, TemperatureUnit.CELCIUS);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.KELVIN);
		Temperature expected = new Temperature(293.65, TemperatureUnit.KELVIN);
		assertValues(output, expected);
	}

	/**
	 * Test for Kelvin to Cencius conversion.
	 */
	@Test
	public void testK2CConversion() {
		Temperature input = new Temperature(293.65, TemperatureUnit.KELVIN);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.CELCIUS);
		Temperature expected = new Temperature(20.5, TemperatureUnit.CELCIUS);
		assertValues(output, expected);
	}

	/**
	 * Test for Kelvin to Fahrenheit conversion.
	 */
	@Test
	public void testK2FConversion() {
		Temperature input = new Temperature(273.15, TemperatureUnit.KELVIN);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.FAHRENHEIT);
		Temperature expected = new Temperature(32, TemperatureUnit.FAHRENHEIT);
		assertValues(output, expected);
	}

	/**
	 * Test for Fahrenheit to Kelvin conversion.
	 */
	@Test
	public void testF2KConversion() {
		Temperature input = new Temperature(32, TemperatureUnit.FAHRENHEIT);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.KELVIN);
		Temperature expected = new Temperature(273.15, TemperatureUnit.KELVIN);
		assertValues(output, expected);
	}

	/**
	 * Test for Fahrenheit to Fahrenheit conversion.
	 */
	@Test
	public void testF2FConversion() {
		Temperature input = new Temperature(32, TemperatureUnit.FAHRENHEIT);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.FAHRENHEIT);
		assertValues(output, input);
	}

	/**
	 * Test for Kelvin to Kelvin conversion.
	 */
	@Test
	public void testK2KConversion() {
		Temperature input = new Temperature(32, TemperatureUnit.KELVIN);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.KELVIN);
		assertValues(output, input);
	}

	/**
	 * Test for Celcius to Celcius conversion.
	 */
	@Test
	public void testC2CConversion() {
		Temperature input = new Temperature(0, TemperatureUnit.CELCIUS);
		Temperature output = TemperatureConverter.convert(input, TemperatureUnit.CELCIUS);
		assertValues(output, input);
	}

	/**
	 * Asserts for test cases.
	 * 
	 * @param output
	 * @param expected
	 */
	private void assertValues(Temperature output, Temperature expected) {
		Assert.assertEquals(temperatureFormatter.format(expected.getValue()),
				temperatureFormatter.format(output.getValue()));
		Assert.assertTrue(expected.getUnit() == output.getUnit());
	}
}
