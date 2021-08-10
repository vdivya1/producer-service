package com.prokarma.publisher.customer.customerpublisher.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		if (authException instanceof InsufficientAuthenticationException) {

			response.getOutputStream().println("{ " + "\"message\": \"Insufficient Data Entered\","
					+ "\"type\": \"Unauthorized\"," + "\"status\": 401" + "}");
		}
		if (authException.getCause() instanceof InvalidTokenException) {
			response.getOutputStream().println("{ " + "\"message\": \"Token has expired\","
					+ "\"type\": \"Unauthorized\"," + "\"status\": 401" + "}");
		}

		if (authException instanceof AuthenticationCredentialsNotFoundException) {

			response.getOutputStream().println("{ " + "\"message\": \"Missing Authorization Header\","
					+ "\"type\": \"Unauthorized\"," + "\"status\": 401" + "}");
		}

	}

}
