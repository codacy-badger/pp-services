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
import javax.validation.constraints.Size;

import br.com.passeio_pago.location_tour.domain.LocationTourPublic;
import br.com.passeio_pago.tour.domain.entity.TourEntity;

@Entity
@Table(name = "location_tour")
public class LocationTourEntity implements LocationTourPublic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2085787632567231708L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_tour_sequence")
	@SequenceGenerator(name = "location_tour_sequence", sequenceName = "location_tour_sequence")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "street", nullable = true)
	private String street;

	@Column(name = "province", nullable = false)
	private String province;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "state", nullable = false, length = 2)
	@Size(min = 2, max = 2)
	private String state;

	@Column(name = "state_full_name", nullable = false)
	private String stateFullName;

	@Column(name = "zip_code", nullable = true, length = 10)
	private String zipCode;

	@Column(name = "contacts", nullable = true)
	private String[] contacts;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "locationTour")
	private List<TourEntity> tours;

	public LocationTourEntity(Long id) {
		super();
		this.id = id;
	}

	public LocationTourEntity() {
		super();
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

	public List<TourEntity> getTours() {
		return tours;
	}

	public void setTours(List<TourEntity> tours) {
		this.tours = tours;
	}

}
