package com.visioninfinity.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class WeatherInfo {

	private String city;
	private LocalTime sunriseTime;
	private LocalTime sunsetTime;
	private Temperature temperature;
	private LocalDateTime todaysDate;
	private String weatherDescription;

	public WeatherInfo(String city, String weatherDescription, 
			Temperature temperature, LocalDateTime today,
			LocalTime sunriseTime, LocalTime sunsetTime) {
		this.city = city;
		this.temperature = temperature;
		this.setTodaysDate(today);
		this.weatherDescription = weatherDescription;
		this.sunriseTime = sunriseTime;
		this.sunsetTime = sunsetTime;
	}

	public String getCity() {
		return city;
	}

	public LocalTime getSunriseTime() {
		return sunriseTime;
	}

	public LocalTime getSunsetTime() {
		return sunsetTime;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public LocalDateTime getTodaysDate() {
		return todaysDate;
	}

	public String getOverview() {
		return weatherDescription;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setSunriseTime(LocalTime sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public void setSunsetTime(LocalTime sunsetTime) {
		this.sunsetTime = sunsetTime;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public void setTodaysDate(LocalDateTime todaysDate) {
		this.todaysDate = todaysDate;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

}
