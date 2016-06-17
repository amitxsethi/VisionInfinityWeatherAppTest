package com.visioninfinity.util;

import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.visioninfinity.model.ErrorResponse;

/**
 * The Parser interface that all the Parsers should implement from.
 * 
 * @author amit.x.sethi
 */
public interface DataParser {

	public static final String MESSAGE = "message";
	public static final String CODE = "cod";

	/**
	 * The default implementation of how to parse Error response and retrieve error code and message.
	 * The implementing classes can override the implementation to suit more detailed operations.
	 * @param responseJsonData - the json string consisting of error information.
	 * @return <code>Optional<ErrorResponse> </code> will be empty if there is no valid json to parse.
	 */
	public default Optional<ErrorResponse> parseErrorResponse(String responseJsonData) {
		Optional<ErrorResponse> response = Optional.empty();
		try {
			if (responseJsonData != null) {
				JSONObject weatherJsonObject = new JSONObject(responseJsonData);
				if (weatherJsonObject != null) {
					String code = weatherJsonObject.getString(CODE);
					String message = weatherJsonObject.getString(MESSAGE);
					if (code != null && message != null) {
						response = Optional.of(new ErrorResponse(code, message));
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return response;
	}
}
