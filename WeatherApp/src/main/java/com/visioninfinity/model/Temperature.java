package com.visioninfinity.model;

/**
 * Temperature domain object consisting of value and TemperatureUnit.
 * @author amit.x.sethi
 */
public class Temperature {

	private Double value;
	private TemperatureUnit unit;
	
	/**
	 * Constructor
	 * @param value - the double value
	 * @param unit - the unit of the temperature
	 */
	public Temperature(double value, TemperatureUnit unit) {
		this.value = value;
		this.unit = unit;
	}

	/**
	 * Returns the value.
	 * @return - value.
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Sets the value of the <code>Temperature</code>.
	 * @param value - the value to be set.
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * Returns the <code>TemperatureUnit</code>.
	 * @return - unit of the temperature.
	 */
	public TemperatureUnit getUnit() {
		return unit;
	}
	
	/**
	 * Sets the unit of the <code>Temperature</code>.
	 * @param unit - the unit to be set.
	 */
	public void setUnit(TemperatureUnit unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return value + " " + unit;
	}
	
}
