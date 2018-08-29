package br.com.passeio_pago.location_tour.domain;

import java.io.Serializable;
import java.util.List;

import br.com.passeio_pago.tour.domain.entity.TourEntity;

public interface LocationTourPublic extends Serializable {
	Long getId();

	String getName();

	String getStreet();

	String getProvince();

	String getCity();

	String getState();

	String getStateFullName();

	String getZipCode();
	
	String[] getContacts();
	
	List<TourEntity> getTours();
}
