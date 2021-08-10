package com.prokarma.publisher.customer.customerpublisher.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.publisher.customer.customerpublisher.converters.CustomerPublisherConverter;
import com.prokarma.publisher.customer.customerpublisher.domain.Address;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequestVO;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherSuccessResponse;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest.CustomerStatusEnum;
import com.prokarma.publisher.customer.customerpublisher.service.CustomerPublisherService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerPublisherController.class)
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureWebClient
public class PublisherControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@MockBean
	CustomerPublisherService publisherService;

	@MockBean
	CustomerPublisherConverter<PublisherRequest, PublisherRequestVO> publisherConverter;
	PublisherRequestVO publisherRequestVOMock;
	PublisherSuccessResponse successResponse;

	@Before
	public void setUp() {
		publisherRequestVOMock = Mockito.mock(PublisherRequestVO.class);
		successResponse = Mockito.mock(PublisherSuccessResponse.class);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void publisherCustomerDeatilsTest() throws JsonProcessingException, Exception {
		Mockito.when(publisherConverter.convert(new PublisherRequest())).thenReturn(publisherRequestVOMock);
		Mockito.when(publisherService.publishMessage(new PublisherRequest())).thenReturn(successResponse);
		mockMvc.perform(MockMvcRequestBuilders.post("/customer/publisherMessage")
				.content(new ObjectMapper().writeValueAsString(publisherDeatilsRequest())).headers(getHeaders())
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void badRequestExceptionTest() throws JsonProcessingException, Exception {
		PublisherRequest request = publisherDeatilsRequest();
		request.setCustomerNumber("");
		Mockito.when(publisherConverter.convert(new PublisherRequest())).thenReturn(publisherRequestVOMock);
		Mockito.when(publisherService.publishMessage(new PublisherRequest())).thenReturn(successResponse);
		mockMvc.perform(MockMvcRequestBuilders.post("/customer/publisherMessage")
				.content(new ObjectMapper().writeValueAsString(request)).headers(getHeaders())
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(400))
				.andReturn();
	}

	@Test
	public void httpStatusNotFoundExceptionTest() throws JsonProcessingException, Exception {
		PublisherRequest request = publisherDeatilsRequest();
		Mockito.when(publisherConverter.convert(new PublisherRequest())).thenReturn(publisherRequestVOMock);
		Mockito.when(publisherService.publishMessage(publisherDeatilsRequest())).thenReturn(successResponse);
		mockMvc.perform(MockMvcRequestBuilders.post("/customer/publisherMe")
				.content(new ObjectMapper().writeValueAsString(request)).headers(getHeaders())
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(404))
				.andReturn();
	}

	private HttpHeaders getHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "Bearer 76d0e8d3-3ec1-42d8-a04f-7219d9e9185e");
		httpHeaders.set("Transaction-Id", "123");
		httpHeaders.set("Activity-Id", "2343");

		return httpHeaders;
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
}
