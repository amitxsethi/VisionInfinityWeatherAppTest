package com.visioninfinity.commons;

/**
 * Contains common constants.
 * 
 * @author amit.x.sethi
 */
public final class Constants {

	/**
	 * The parameter to set appId in the weather fetch API.
	 */
	public static final String APP_ID_PARAM_KEY = "&appid=";

	/**
	 * The constant to look up the API KEY for retrieving the current weather from external API.
	 */
	public static final String CURRENT_WEATHER_BY_CITY_API_KEY = "currentWeatherByCityApiKey";

	/**
	 * The constant used to display message on the top of weather.jsp page
	 */
	public static final String DISPLAY_MSG = "displayMessage";

	/**
	 * The constant to set the error response in the jsp page.
	 */
	public static final String ERROR_INFO = "errorInfo";

	/**
	 * The info message to be displayed when the city name was not matched
	 * exactly, but still best match possible was returned.
	 */
	public static final String MSG_EXACT_CITY_NOT_MATCHED = "Exact City match not Found, Returning the best match possible";
	
	/**
	 * Info message to be displayed when city field is left blank.
	 */
	public static final String MSG_PROMPT_CITY = "Please Enter City";
	
	/**
	 * The API to fetch weather information from openweathermap.org
	 */
	public static final String WEATHER_API = "http://api.openweathermap.org/data/2.5/weather?q=";
	
	/**
	 * The constant to set the success weatherInfo response in the jsp page.
	 */
	public static final String WEATHER_INFO = "weatherInfo";
	
	/**
	 * The weather.jsp view to display the input form and output table.
	 */
	public static final String WEATHER_VIEW = "/weather.jsp";
}
