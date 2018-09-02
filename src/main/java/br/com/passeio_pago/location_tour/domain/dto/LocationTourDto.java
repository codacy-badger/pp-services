package br.com.passeio_pago.location_tour.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import br.com.passeio_pago.common.util.CommonPatterns;
import io.swagger.annotations.ApiModel;

@ApiModel
public class LocationTourDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8509322294354492440L;
	private Long id;
	private String name;
	private String street;
	private String province;
	private String city;
	private String state;
	private String stateFullName;
	private String zipCode;
	@Pattern(regexp = CommonPatterns.PHONE_NUMBER_PATTERN)
	private String phoneNumber;

	public LocationTourDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
