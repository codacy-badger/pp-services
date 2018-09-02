package br.com.passeio_pago.location_tour.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.passeio_pago.common.util.CommonPatterns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class LocationTourRegistrationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6317410428712322622L;

	@ApiModelProperty(required = true, example = "Parque Hopi Hari", value = "Property to define the name of the location where the tour will be.")
	@NotBlank
	@Size(max = 400)
	private String name;

	@ApiModelProperty(required = false, example = "Rodovia dos Bandeirantes, km 72, s/n", value = "Property to define the street of the location.")
	@Size(max = 400)
	private String street;

	@ApiModelProperty(required = true, example = "Vinhedo", value = "Property to define the province of the location.")
	@NotBlank
	@Size(max = 200)
	private String province;

	@ApiModelProperty(required = true, example = "Moinho", value = "Property to define the city of the location.")
	@NotBlank
	@Size(max = 200)
	private String city;

	@ApiModelProperty(required = true, example = "SP", value = "Property to define the state's initials of the location tour.")
	@NotBlank
	@Size(min = 2, max = 2)
	private String state;

	@ApiModelProperty(required = true, example = "São Paulo", value = "Property to define the state's full name of the location tour.")
	@NotBlank
	@Size(max = 200)
	private String stateFullName;

	@ApiModelProperty(required = false, example = "13288-130", value = "Property to define the zip code of the location tour.")
	@Size(min = 9, max = 9)
	private String zipCode;

	@ApiModelProperty(required = false, example = "(11) 98832-0100", value = "Property to define some contatics of the location.  Must be in the format \"(dd) xxxx-xxxx\".")
	@Pattern(regexp = CommonPatterns.PHONE_NUMBER_PATTERN)
	@Size(max = 30)
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateFullName() {
		return stateFullName;
	}

	public void setStateFullName(String stateFullName) {
		this.stateFullName = stateFullName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
