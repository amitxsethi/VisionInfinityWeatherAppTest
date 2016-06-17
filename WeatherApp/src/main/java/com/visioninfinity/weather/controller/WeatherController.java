package com.visioninfinity.weather.controller;

import java.util.Optional;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.visioninfinity.commons.Constants;
import com.visioninfinity.model.ErrorResponse;
import com.visioninfinity.model.WeatherInfo;
import com.visioninfinity.util.WeatherInfoParser;

/**
 * Controller class for the Weather Controller application. It provides current
 * weather information for a City.
 * 
 * @author amit.x.sethi
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

	private WeatherInfoParser weatherInfoParser;

	@Resource(name = "apiProperties")
	private Properties apiProperties;
	
	private static Log LOGGER = LogFactory.getLog(WeatherController.class);

	/**
	 * Retrieves current weather information for a given city.
	 * 
	 * @param city
	 *            - city name for which weather info to be retrieved.
	 * @return <code>ModelAndView</code> the ModelAndView consisting of
	 *         <code>ModelMap</code> and JSP <code>View</code>.
	 */
	@RequestMapping(value = "/current")
	public ModelAndView currentWeather(@RequestParam(required = false) String city) {
		ModelMap modelMap = new ModelMap();
		if (city == null) {
			LOGGER.info("City not provided");
		} else if (city.trim().isEmpty()) {
			LOGGER.info("Empty city provided");
			modelMap.put(Constants.DISPLAY_MSG, Constants.MSG_PROMPT_CITY);
		} else {
			LOGGER.info("Fetching the current weather information for city =" + city);
			RestTemplate restTemplate = new RestTemplate();
			String appKeyValue = apiProperties.getProperty(Constants.CURRENT_WEATHER_BY_CITY_API_KEY).trim();
			String url = new StringBuilder(Constants.WEATHER_API).append(city).append(Constants.APP_ID_PARAM_KEY).append(appKeyValue)
					.toString();
			try {
				String response = restTemplate.getForObject(url, String.class);
				LOGGER.info("Response received from whether API webservice" + response);
				Optional<WeatherInfo> weatherInfo = WeatherInfoParser.parseData(response);
				weatherInfo.ifPresent(info -> {
					LOGGER.info("Weather Info successfully parsed");
					modelMap.put(Constants.WEATHER_INFO, info);
					if (!city.equalsIgnoreCase(info.getCity())) {
						modelMap.put(Constants.DISPLAY_MSG, Constants.MSG_EXACT_CITY_NOT_MATCHED);
					}
				});
				if (!weatherInfo.isPresent()) {
					LOGGER.info("Not able to parse weather info. Parsing the error response now.");
					Optional<ErrorResponse> errorResponse = weatherInfoParser.parseErrorResponse(response);
					errorResponse.ifPresent(item -> modelMap.put(Constants.DISPLAY_MSG, item.getMessage()));
				}
			} catch (RestClientException rce) {
				LOGGER.error("Exception occured during webservice call", rce);
				modelMap.put(Constants.DISPLAY_MSG, rce.getLocalizedMessage());
			}
		}
		LOGGER.info("Returning to the view " + Constants.WEATHER_VIEW);
		return new ModelAndView(Constants.WEATHER_VIEW, modelMap);
	}

	/**
	 * setter for <code>WeatherInfoParser</code>.
	 * 
	 * @param weatherInfoParser
	 *            - the <code>WeatherInfoParser</code> to set.
	 */
	@Autowired
	public void setWeatherInfoParser(WeatherInfoParser weatherInfoParser) {
		this.weatherInfoParser = weatherInfoParser;
	}
}
