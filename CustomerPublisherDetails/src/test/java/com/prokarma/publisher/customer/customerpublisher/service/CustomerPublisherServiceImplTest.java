package com.prokarma.publisher.customer.customerpublisher.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;

import com.prokarma.publisher.customer.customerpublisher.domain.Address;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest.CustomerStatusEnum;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherSuccessResponse;

@ExtendWith(MockitoExtension.class)
 class CustomerPublisherServiceImplTest {
	@InjectMocks
	CustomerPublisherServiceImpl customerPublisherServiceImpl;

	@Mock
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Test
	void publishMessageSuccessTest() {
		PublisherRequest publisherDeatilsRequest = publisherDeatilsRequest();
		PublisherSuccessResponse publishMessage = customerPublisherServiceImpl.publishMessage(publisherDeatilsRequest);
		assertEquals(buildMessageResponse(), publishMessage);
	}

	@Test
	void publishMessageFailureTest() {
		PublisherSuccessResponse publishMessage = customerPublisherServiceImpl.publishMessage(null);
		assertEquals(buildMessageResponse(), publishMessage);
	}

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

	private PublisherSuccessResponse buildMessageResponse() {
		PublisherSuccessResponse response = new PublisherSuccessResponse();
		response.setCode(HttpStatus.OK.value());
		response.setMessage("Message Published Successfully");
		return response;
	}
}
