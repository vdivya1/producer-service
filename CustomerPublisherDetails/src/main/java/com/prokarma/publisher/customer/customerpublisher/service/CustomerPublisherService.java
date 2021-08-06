package com.prokarma.publisher.customer.customerpublisher.service;

import javax.validation.Valid;

import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherSuccessResponse;

public interface CustomerPublisherService {
	public PublisherSuccessResponse publishMessage(@Valid PublisherRequest publisherRequest);

}
