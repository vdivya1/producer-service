package com.prokarma.publisher.customer.customerpublisher.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PublisherRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-30T11:57:58.245Z")

public class PublisherRequest {
	@JsonProperty("customerNumber")
	private String customerNumber = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	@JsonProperty("birthDate")
	private String birthDate = null;

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("countryCode")
	private String countryCode = null;

	@JsonProperty("mobileNumber")
	private String mobileNumber = null;

	@JsonProperty("email")
	private String email = null;

	/**
	 * Gets or Sets customerStatus
	 */
	public enum CustomerStatusEnum {
		OPEN("Open"),

		CLOSED("Closed"),

		SUSPENDED("Suspended"),

		RESTORED("Restored");

		private String value;

		CustomerStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static CustomerStatusEnum fromValue(String text) {
			for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@ApiModelProperty(required = true, value = "")
	@JsonProperty("customerStatus")
	private CustomerStatusEnum customerStatus = null;

	@JsonProperty("address")
	@Valid
	private Address address = new Address();

	public PublisherRequest customerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
		return this;
	}

	/**
	 * Get customerNumber
	 * 
	 * @return customerNumber
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	@Pattern(regexp = "^[C][0-9]*$",message ="The CustomerNumber must be starts with C and have lenght 10")
	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public PublisherRequest firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Size(min = 10, max = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public PublisherRequest lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Size(min = 10, max = 50)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PublisherRequest birthDate(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	/**
	 * Get birthDate
	 * 
	 * @return birthDate
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$")
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public PublisherRequest country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public PublisherRequest countryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	/**
	 * Get countryCode
	 * 
	 * @return countryCode
	 **/
	@ApiModelProperty(example = "IN", required = true, value = "")
	@NotNull

	@Pattern(regexp = "^[A-Z][A-Z]$")
	@Size(min = 2, max = 2)
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public PublisherRequest mobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	/**
	 * Get mobileNumber
	 * 
	 * @return mobileNumber
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	@Size(min = 10, max = 10)
    @Pattern(regexp="(0/91)?[7-9][0-9]{9}")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public PublisherRequest email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	@ApiModelProperty(value = "")

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	@Size(min = 1, max = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PublisherRequest customerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
		return this;
	}

	/**
	 * Get customerStatus
	 * 
	 * @return customerStatus
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public CustomerStatusEnum getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
	}

	public PublisherRequest address(Address address) {
		this.address = address;
		return this;
	}

	/**
	 * Get address
	 * 
	 * @return address
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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
		PublisherRequest publisherRequest = (PublisherRequest) o;
		return Objects.equals(this.customerNumber, publisherRequest.customerNumber)
				&& Objects.equals(this.firstName, publisherRequest.firstName)
				&& Objects.equals(this.lastName, publisherRequest.lastName)
				&& Objects.equals(this.birthDate, publisherRequest.birthDate)
				&& Objects.equals(this.country, publisherRequest.country)
				&& Objects.equals(this.countryCode, publisherRequest.countryCode)
				&& Objects.equals(this.mobileNumber, publisherRequest.mobileNumber)
				&& Objects.equals(this.email, publisherRequest.email)
				&& Objects.equals(this.customerStatus, publisherRequest.customerStatus)
				&& Objects.equals(this.address, publisherRequest.address);
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
