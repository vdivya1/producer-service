package com.prokarma.publisher.customer.customerpublisher.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherSuccessResponse;
import com.prokarma.publisher.customer.customerpublisher.exceptions.InvalidCodeException;

@Service
public class CustomerPublisherServiceImpl implements CustomerPublisherService {
	private static final Logger logger = LogManager.getLogger(CustomerPublisherServiceImpl.class);
	@Value("${spring.kafka.producer.topic}")
	private String topic;

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	@Override
	public PublisherSuccessResponse publishMessage(PublisherRequest publisherRequest) {
		try {
			logger.info("Publiser data sending to kafka" + publisherRequest);
			kafkaTemplate.send(topic, publisherRequest);
			logger.info("Response received from kafka" + publisherRequest);
		} catch (Exception e) {
			throw new InvalidCodeException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
					e.getClass().getName());
		}
		return customerSuccessResponse();
	}

	private PublisherSuccessResponse customerSuccessResponse() {
		PublisherSuccessResponse publisherResponse = new PublisherSuccessResponse();
		publisherResponse.setCode(HttpStatus.OK.value());
		publisherResponse.setMessage("Message Published Successfully");
		return publisherResponse;

	}
}
