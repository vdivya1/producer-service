package com.prokarma.publisher.customer.customerpublisher.exceptions;

public class InvalidCodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code = null;

	private String message = null;
	private String errorType = null;

	public InvalidCodeException(Integer code, String message, String errorType) {
		super();
		this.code = code;
		this.message = message;
		this.errorType = errorType;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
