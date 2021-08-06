package com.prokarma.publisher.customer.customerpublisher.constants;

public enum PublisherConstants {
	EMAIL_ID_REG_EXP_CONSTANT(".(?<!.{5})"), CUSTOMER_NUMBER_REG_EXP_CONSTANT("\\w(?<=\\w{7})"),
	BIRTHDAY_DATE_REG_EXP_CONSTANT("\\d(?=[^-]*?-)"),MASKWITH("*");
	private String regularExpression;

	private PublisherConstants(String regularExpression) {
		this.regularExpression = regularExpression;
	}

	public String getRegularExpression() {
		return regularExpression;
	}

}
