package br.com.passeio_pago.location_tour.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.passeio_pago.tour.domain.entity.TourEntity;

@Entity
@Table(name = "location_tour")
public class LocationTourEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_tour_sequence")
	@SequenceGenerator(name = "location_tour_sequence", sequenceName = "location_tour_sequence")
	private Long id;

	@Column(name = "name", nullable = false, length = 400)
	private String name;

	@Column(name = "street", nullable = true, length = 400)
	private String street;

	@Column(name = "province", nullable = false, length = 200)
	private String province;

	@Column(name = "city", nullable = false, length = 200)
	private String city;

	@Column(name = "state", nullable = false, length = 2)
	private String state;

	@Column(name = "state_full_name", nullable = false, length = 200)
	private String stateFullName;

	@Column(name = "zip_code", nullable = true, length = 9)
	private String zipCode;

	@Column(name = "phone_number", nullable = false, length = 30)
	private String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "locationTour")
	private List<TourEntity> tours;

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

	public List<TourEntity> getTours() {
		return tours;
	}

	public void setTours(List<TourEntity> tours) {
		this.tours = tours;
	}

}
