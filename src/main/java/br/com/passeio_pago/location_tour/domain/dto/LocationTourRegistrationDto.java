package br.com.passeio_pago.location_tour.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class LocationTourRegistrationDto {

	@ApiModelProperty(required = true, example = "Parque Hopi Hari", value = "Property to define the name of the school tour.")
	@NotBlank
	private String name;

	@ApiModelProperty(required = false, example = "Rua Sales, 444", value = "Property to define the street of the location tour")
	private String street;

	@ApiModelProperty(required = true, example = "Centro", value = "Property to define the province of the location tour.")
	@NotBlank
	private String province;

	@ApiModelProperty(required = true, example = "Osasco", value = "Property to define the city of the location tour.")
	@NotBlank
	private String city;

	@ApiModelProperty(required = true, example = "SP", value = "Property to define the state's initials of the location tour.")
	@NotBlank
	@Size(min = 2, max = 2)
	private String state;

	@ApiModelProperty(required = true, example = "São Paulo", value = "Property to define the state's full name of the location tour.")
	@NotBlank
	private String stateFullName;

	@ApiModelProperty(required = false, example = "545415150", value = "Property to define the zip code of the location tour.")
	@Size(min = 9, max = 9)
	private String zipCode;

	@ApiModelProperty(required = false, value = "Property to define some contatics of the location tour.")
	private String[] contacts;

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

	public String[] getContacts() {
		return contacts;
	}

	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}

}
