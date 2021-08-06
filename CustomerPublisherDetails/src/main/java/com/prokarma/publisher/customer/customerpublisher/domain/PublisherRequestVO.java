package com.prokarma.publisher.customer.customerpublisher.domain;

import java.util.Objects;

import com.prokarma.publisher.customer.customerpublisher.domain.PublisherRequest.CustomerStatusEnum;

public class PublisherRequestVO {
	private String customerNumber = null;

	private String firstName = null;

	private String lastName = null;

	private String birthDate = null;

	private String country = null;

	private String countryCode = null;

	private String mobileNumber = null;

	private String email = null;

	private CustomerStatusEnum customerStatus = null;
	private AddressVO address = new AddressVO();

	/**
	 * Get customerNumber
	 * 
	 * @return customerNumber
	 **/

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get birthDate
	 * 
	 * @return birthDate
	 **/
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 **/
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get countryCode
	 * 
	 * @return countryCode
	 **/
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Get mobileNumber
	 * 
	 * @return mobileNumber
	 **/
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get customerStatus
	 * 
	 * @return customerStatus
	 **/
	public CustomerStatusEnum getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
	}
	
	/**
	 * Get address
	 * 
	 * @return address
	 **/
	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PublisherRequestVO publisherRequestVO = (PublisherRequestVO) o;
		return Objects.equals(this.customerNumber, publisherRequestVO.customerNumber)
				&& Objects.equals(this.firstName, publisherRequestVO.firstName)
				&& Objects.equals(this.lastName, publisherRequestVO.lastName)
				&& Objects.equals(this.birthDate, publisherRequestVO.birthDate)
				&& Objects.equals(this.country, publisherRequestVO.country)
				&& Objects.equals(this.countryCode, publisherRequestVO.countryCode)
				&& Objects.equals(this.mobileNumber, publisherRequestVO.mobileNumber)
				&& Objects.equals(this.email, publisherRequestVO.email)
				&& Objects.equals(this.customerStatus, publisherRequestVO.customerStatus)
				&& Objects.equals(this.address, publisherRequestVO.address);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(customerNumber, firstName, lastName, birthDate, country, countryCode, mobileNumber, email,
				customerStatus, address);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PublisherRequest {\n");

		sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
		sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
