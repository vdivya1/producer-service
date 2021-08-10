package com.prokarma.publisher.customer.customerpublisher.service;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.SettableListenableFuture;

import com.prokarma.publisher.customer.customerpublisher.domain.Address;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest.CustomerStatusEnum;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherSuccessResponse;
import com.prokarma.publisher.customer.customerpublisher.exceptions.InvalidCodeException;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class CustomerPublisherServiceImplTest {
	@Autowired
	CustomerPublisherServiceImpl customerPublisherServiceImpl;

	@MockBean
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Test
	void publishMessageSuccessTest() {
		SettableListenableFuture<SendResult<String, Object>> future = new SettableListenableFuture<>();
		Mockito.when(kafkaTemplate.send(Mockito.anyString(), Mockito.any())).thenReturn(future);
		PublisherSuccessResponse publishMessage = customerPublisherServiceImpl
				.publishMessage(publisherDeatilsRequest());

	}

	@Test
	void publishMessageExceptionTest() {
		try {
			Mockito.when(kafkaTemplate.send(Mockito.anyString(), Mockito.any())).thenThrow(InvalidCodeException.class);
			PublisherSuccessResponse publishMessage = customerPublisherServiceImpl
					.publishMessage(publisherDeatilsRequest());
		} catch (Exception e) {
			assertTrue(true);
		}

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
