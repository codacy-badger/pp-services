package br.com.passeio_pago.location_tour.domain.dto;

import br.com.passeio_pago.location_tour.domain.LocationTourPublic;
import io.swagger.annotations.ApiModel;

@ApiModel
public class LocationTourPublicDto implements LocationTourPublic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3438297282281767341L;
	private Long id;
	private String name;
	private String street;
	private String province;
	private String city;
	private String state;
	private String stateFullName;
	private String zipCode;
	private String[] contacts;

	public LocationTourPublicDto() {
		super();
	}

	public LocationTourPublicDto(LocationTourPublic locationTourPublic) {
		this(locationTourPublic.getId(), locationTourPublic.getName(), locationTourPublic.getStreet(), locationTourPublic.getProvince(), locationTourPublic.getCity(), locationTourPublic.getState(),
				locationTourPublic.getStateFullName(), locationTourPublic.getZipCode(), locationTourPublic.getContacts());
	}

	public LocationTourPublicDto(Long id, String name, String street, String province, String city, String state, String stateFullName, String zipCode, String[] contacts) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.province = province;
		this.city = city;
		this.state = state;
		this.stateFullName = stateFullName;
		this.zipCode = zipCode;
		this.contacts = contacts;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getStateFullName() {
		return stateFullName;
	}

	public void setStateFullName(String stateFullName) {
		this.stateFullName = stateFullName;
	}

	@Override
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String[] getContacts() {
		return contacts;
	}

	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}

}
