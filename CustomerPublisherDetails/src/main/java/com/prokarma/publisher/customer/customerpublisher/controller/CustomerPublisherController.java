package com.prokarma.publisher.customer.customerpublisher.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.publisher.customer.customerpublisher.converters.CustomerPublisherConverter;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequestVO;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherSuccessResponse;
import com.prokarma.publisher.customer.customerpublisher.service.CustomerPublisherService;

@RestController
@RequestMapping("/customer")
public class CustomerPublisherController {
	private static final Logger logger = LogManager.getLogger(CustomerPublisherController.class);

	@Autowired
	CustomerPublisherConverter<PublisherRequest, PublisherRequestVO> publisherConverter;

	@Autowired
	CustomerPublisherService publisherService;

	@PostMapping("/publisherMessage")
	public ResponseEntity<PublisherSuccessResponse> publisherCustomerDeatils(
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@RequestHeader(value = "Transaction-Id", required = true) String transactionId,
			@RequestHeader(value = "Activity-Id", required = true) String activityId,
			@RequestBody @Valid PublisherRequest publisherRequest) {
		logger.info("Request headers:" + transactionId + "" + activityId);
		logger.info("Request body:", publisherRequest );
		PublisherRequestVO maskingResponse = publisherConverter.convert(publisherRequest);
		logger.info("MaskingResponse:" + maskingResponse);
		PublisherSuccessResponse publisherResponse = publisherService.publishMessage(publisherRequest);
		return new ResponseEntity<PublisherSuccessResponse>(publisherResponse,HttpStatus.OK);
	}

}
