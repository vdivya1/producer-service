package com.prokarma.publisher.customer.customerpublisher.converters;

public interface CustomerPublisherConverter<I,O> {
  O convert(I input);
}
