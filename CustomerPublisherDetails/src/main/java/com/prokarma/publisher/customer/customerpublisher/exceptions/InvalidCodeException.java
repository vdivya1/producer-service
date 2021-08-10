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

}
