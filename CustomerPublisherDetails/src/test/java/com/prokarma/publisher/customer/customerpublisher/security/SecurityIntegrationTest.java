package com.prokarma.publisher.customer.customerpublisher.security;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.prokarma.publisher.customer.customerpublisher.domain.Address;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest.CustomerStatusEnum;
import com.prokarma.publisher.customer.customerpublisher.utils.CustomerMapper;

@Tag("Integration")
@SpringBootTest
public class SecurityIntegrationTest {
	@Autowired
	private MockMvc springmvc;
	@Autowired
	WebApplicationContext context;
	@Autowired
	FilterChainProxy springSecurityFilterChain;

	@BeforeEach
	public void setUp() {
		springmvc = MockMvcBuilders.webAppContextSetup(context).addFilter(springSecurityFilterChain).build();
	}

	@Test
	void authorizedTokenTest() throws Exception {
		String accessToken = getAccessToken("client", "secret");
		springmvc
				.perform(post("/customer-publish/v1/publish-message").contentType(MediaType.APPLICATION_JSON)
						.header("Activity-Id", "123487264").header("Authorization", "Bearer " + accessToken)
						.header("Transaction-Id", "323232").content(CustomerMapper.jsonString(publisherDeatilsRequest())))
				.andExpect(status().isOk());
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

	private String getAccessToken(String username, String password) throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "password");
		params.add("username", username);
		params.add("password", password);
		ResultActions result = springmvc.perform(post("/oauth/token").params(params).with(httpBasic(username, password))
				.accept("application/json;charset=UTF-8")).andExpect(status().isOk());
		String resultString = result.andReturn().getResponse().getContentAsString();
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(resultString).get("access_token").toString();
	}

}
