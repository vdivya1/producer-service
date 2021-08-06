package com.prokarma.publisher.customer.customerpublisher.converters;

import org.springframework.stereotype.Component;

import com.prokarma.publisher.customer.customerpublisher.constants.PublisherConstants;
import com.prokarma.publisher.customer.customerpublisher.domain.Address;
import com.prokarma.publisher.customer.customerpublisher.domain.AddressVO;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest;
import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequestVO;

@Component
public class CustomerPublisherConverterImpl
		implements CustomerPublisherConverter<PublisherRequest, PublisherRequestVO> {

	@Override
	public PublisherRequestVO convert(PublisherRequest input) {

		PublisherRequestVO requestVO = new PublisherRequestVO();
		requestVO.setAddress(addresssDetails(input.getAddress()));
		requestVO.setBirthDate(input.getBirthDate());
		requestVO.setCountry(input.getCountry());
		requestVO.setCountryCode(input.getCountryCode());
		requestVO.setCustomerNumber(input.getCustomerNumber());
		requestVO.setEmail(input.getEmail());
		requestVO.setFirstName(input.getFirstName());
		requestVO.setLastName(input.getLastName());
		requestVO.setMobileNumber(input.getMobileNumber());
		maskPublisherRequest(requestVO);
		return requestVO;
	}

	private PublisherRequestVO maskPublisherRequest(PublisherRequestVO input) {
		input.setBirthDate(input.getBirthDate().replaceAll(
				PublisherConstants.BIRTHDAY_DATE_REG_EXP_CONSTANT.getRegularExpression(),
				PublisherConstants.MASKWITH.getRegularExpression()));
		input.setCustomerNumber(input.getCustomerNumber().replaceAll(
				PublisherConstants.CUSTOMER_NUMBER_REG_EXP_CONSTANT.getRegularExpression(),
				PublisherConstants.MASKWITH.getRegularExpression()));
		input.setEmail(
				input.getEmail().replaceAll(PublisherConstants.EMAIL_ID_REG_EXP_CONSTANT.getRegularExpression(),
						PublisherConstants.MASKWITH.getRegularExpression()));
		return input;
	}

	private AddressVO addresssDetails(Address address) {
		AddressVO addressVO = new AddressVO();
		addressVO.setAddressLine1(address.getAddressLine1());
		addressVO.setAddressLine2(address.getAddressLine2());
		addressVO.setPinCode(address.getPinCode());
		addressVO.setStreet(address.getStreet());
		return addressVO;
	}

}
