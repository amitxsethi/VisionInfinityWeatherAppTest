package com.visioninfinity.model;

/**
 * The ErrorResponse Object. 
 * @author amit.x.sethi
 */
public class ErrorResponse {
	private String code;
	private String message;

	/**
	 * Constructor to create ErrorResponse Object. 
	 * @param code - the ErrorCode.
	 * @param message - the ErrorMessage.
	 */
	public ErrorResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Returns the message of the error response.
	 * @return - the message of the error response.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter for the message.
	 * @param message - the error message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Returns the code of the error response.
	 * @return - the code of the error response.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter for the code.
	 * @param code - the error code.
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
