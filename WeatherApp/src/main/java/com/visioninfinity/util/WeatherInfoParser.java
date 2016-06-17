package com.visioninfinity.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.visioninfinity.model.Temperature;
import com.visioninfinity.model.TemperatureUnit;
import com.visioninfinity.model.WeatherInfo;

/**
 * Parser class to parse weather information from json data.
 * 
 * @author amit.x.sethi
 */
@Repository
public class WeatherInfoParser implements DataParser {

	private static final String EUROPE_LONDON = "Europe/London";

	private static final Log logger = LogFactory.getLog(WeatherInfoParser.class);

	/**
	 * Parses response data to <code>Optional<WeatherInfo></code>. The <code>Optional</code> will be empty if the json was not parsable to <code>WeatherInfo</code>
	 * 
	 * @param responseJsonData - the json String to parse the <code>WeatherInfo</code> from.
	 * @return <code>Optional<WeatherInfo></code> consisting of parsed <code>eatherInfo</code> if available.
	 */
	public static Optional<WeatherInfo> parseData(String responseJsonData) {
		Optional<WeatherInfo> weatherInfo = Optional.empty();
		try {
			if (responseJsonData != null) {
				logger.debug("Parsing responseJsonData = " + responseJsonData);
				JSONObject weatherJsonObject = new JSONObject(responseJsonData);
				if (weatherJsonObject != null) {
					String city = weatherJsonObject.getString("name");
					if (city != null) {
						double temperature = new JSONObject(weatherJsonObject.getString("main")).getDouble("temp");

						JSONObject sysJsonObject = new JSONObject(weatherJsonObject.getString("sys"));
						Long sunrise = sysJsonObject.getLong("sunrise");
						Long sunset = sysJsonObject.getLong("sunset");

						Long today = weatherJsonObject.getLong("dt");

						String weatherJsonSring = weatherJsonObject.getString("weather");
						JSONArray weatherJsonArray = new JSONArray(weatherJsonSring);
						String weatherDescription = weatherJsonArray.getJSONObject(0).getString("description");

						/*
						 * TODO the actual zone of the city can be calculated based via another
						 * webservice call as that information is not available via http://openweathermap.org/
						 * 
						 * Hence using EUROPE_LONDON for now so that all the times would be displayed in BST.
						 */
						LocalDateTime todaysDate = DateUtils.getLocalisedDateTimeFromEpoch(today, EUROPE_LONDON);
						LocalTime sunriseTime = DateUtils.getLocalisedDateTimeFromEpoch(sunrise, EUROPE_LONDON).toLocalTime();
						LocalTime sunsetTime = DateUtils.getLocalisedDateTimeFromEpoch(sunset, EUROPE_LONDON).toLocalTime();

						weatherInfo = Optional.of(new WeatherInfo(city, weatherDescription,
								new Temperature(temperature, TemperatureUnit.KELVIN), todaysDate, sunriseTime,
								sunsetTime));
						logger.debug("Parsing complete");
					}
				}
			}
		} catch (JSONException e) {
			logger.debug("Exception while parsing the weather response", e);
		}
		return weatherInfo;
	}
}
