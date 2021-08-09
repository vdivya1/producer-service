
package com.prokarma.publisher.customer.customerpublisher.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.prokarma.publisher.customer.customerpublisher.converters.CustomerPublisherConverterImpl;
import com.prokarma.publisher.customer.customerpublisher.domain.Address;
import com.prokarma.publisher.customer.customerpublisher.domain.AddressVO;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherErrorResponse;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest.CustomerStatusEnum;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequestVO;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherSuccessResponse;
import com.prokarma.publisher.customer.customerpublisher.service.CustomerPublisherService;

@ExtendWith(MockitoExtension.class)
 class CustomerPublisherControllerTest {

	@InjectMocks
	CustomerPublisherController publisherController;

	@Mock
	CustomerPublisherConverterImpl converter;

	@Mock
	CustomerPublisherService publisherService;

	@Test
	 void publisherCustomerDeatilsTest() {
		PublisherRequest request = publisherDeatilsRequest();
		PublisherRequestVO publisherDeatilsRequestVo = publisherDeatilsRequestVo();
		Mockito.when(converter.convert(request)).thenReturn(publisherDeatilsRequestVo);
		Mockito.when(publisherService.publishMessage(publisherDeatilsRequest())).thenReturn(publisherResponse());
		ResponseEntity<PublisherSuccessResponse> publisherCustomerDeatils = publisherController
				.publisherCustomerDeatils("bearer d684882f-34ea-4a0c-a497-c92db343e67a", "132456713245678976543",
						"12342", request);
		assertEquals(publisherCustomerDeatils.getStatusCode().value(), HttpStatus.OK.value());
	}

	/*
	 * @Test public void publisherCustomerDeatilsCustomerNumberTest() {
	 * PublisherRequest request = publisherDeatilsRequest();
	 * request.setCustomerNumber("12"); PublisherSuccessResponse
	 * publisherCustomerDeatils = publisherController.publisherCustomerDeatils(
	 * "bearer d684882f-34ea-4a0c-a497-c92db343e67a", "132456713245678976543",
	 * "12342", request);
	 * assertEquals(publisherCustomerDeatils.getCode(),HttpStatus.BAD_REQUEST.value(
	 * )); }
	 */

	private PublisherRequest publisherDeatilsRequest() {
		Address address = new Address();
		address.setAddressLine1("centenary colony");
		address.setAddressLine2("ramagiri");
		address.setPinCode("50522");
		address.setStreet("tg chowrasta");
		PublisherRequest request = new PublisherRequest();
		request.setAddress(address);
		request.setBirthDate("05-08-2021");
		request.setCountry("India");
		request.setCountryCode("IN");
		request.setCustomerNumber("C123247895");
		request.setCustomerStatus(CustomerStatusEnum.OPEN);
		request.setEmail("divya@gmail.com");
		request.setFirstName("Divyacolony");
		request.setLastName("Vijayagiri");
		request.setMobileNumber("8765432187");

		return request;
	}

	private PublisherRequestVO publisherDeatilsRequestVo() {
		AddressVO address = new AddressVO();
		address.setAddressLine1("centenary colony");
		address.setAddressLine2("ramagiri");
		address.setPinCode("50522");
		address.setStreet("tg chowrasta");
		PublisherRequestVO request = new PublisherRequestVO();
		request.setAddress(address);
		request.setBirthDate("05-08-2021");
		request.setCountry("India");
		request.setCountryCode("IN");
		request.setCustomerNumber("C123247895");
		request.setCustomerStatus(CustomerStatusEnum.OPEN);
		request.setEmail("divya@gmail.com");
		request.setFirstName("Divyacolony");
		request.setLastName("Vijayagiri");
		request.setMobileNumber("8765432187");
		return request;
	}

	private PublisherSuccessResponse publisherResponse() {
		PublisherSuccessResponse response = new PublisherSuccessResponse();
		response.setCode(HttpStatus.OK.value());
		response.setMessage("Message Published Successfully");
		return response;
	}

	private PublisherErrorResponse publisherFailureResponse() {
		MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, null);
		PublisherErrorResponse response = new PublisherErrorResponse();
		response.setCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("headers are missing:" + ex.getMessage());
		response.setErrorType(ex.getClass().getName());
		return response;
	}

}
