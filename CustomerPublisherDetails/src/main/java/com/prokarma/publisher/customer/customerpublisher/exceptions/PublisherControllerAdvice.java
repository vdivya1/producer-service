package com.prokarma.publisher.customer.customerpublisher.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.prokarma.publisher.customer.customerpublisher.domain.PublisherErrorResponse;

@ControllerAdvice
public class PublisherControllerAdvice {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<PublisherErrorResponse> handleException(MethodArgumentNotValidException ex,
			HttpServletRequest req) {
		PublisherErrorResponse response = new PublisherErrorResponse();
		response.setErrorType(ex.getClass().getName());
		response.setMessage("headers are missing:" + ex.getMessage());
		response.setCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<PublisherErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnauthorizedClientException.class)
	public ResponseEntity<PublisherErrorResponse> handleException(UnauthorizedClientException ex,
			HttpServletRequest re) {

		PublisherErrorResponse publisherResponse = new PublisherErrorResponse();
		publisherResponse.setCode(HttpStatus.UNAUTHORIZED.value());
		publisherResponse.setMessage("authorization failed:" + ex.getMessage());
		publisherResponse.setErrorType(ex.getClass().getName());
		return new ResponseEntity<PublisherErrorResponse>(publisherResponse, HttpStatus.UNAUTHORIZED);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<PublisherErrorResponse> handleException(NoHandlerFoundException ex, HttpServletRequest re) {

		PublisherErrorResponse publisherResponse = new PublisherErrorResponse();
		publisherResponse.setCode(HttpStatus.NOT_FOUND.value());
		publisherResponse.setMessage("url or requestbody is invalid:" + ex.getMessage());
		publisherResponse.setErrorType(ex.getClass().getName());
		return new ResponseEntity<PublisherErrorResponse>(publisherResponse, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(InvalidCodeException.class)
	public ResponseEntity<PublisherErrorResponse> handleException(InvalidCodeException ex, HttpServletRequest re) {

		PublisherErrorResponse publisherResponse = new PublisherErrorResponse();
		publisherResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		publisherResponse.setMessage("Error in the code:" + ex.getMessage());
		publisherResponse.setErrorType(ex.getClass().getName());
		return new ResponseEntity<PublisherErrorResponse>(publisherResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
