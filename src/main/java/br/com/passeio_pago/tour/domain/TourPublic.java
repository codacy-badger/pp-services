package br.com.passeio_pago.tour.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.passeio_pago.location_tour.domain.LocationTourPublic;

public interface TourPublic extends Serializable {
	Long getId();

	String getName();

	BigDecimal getPrice();

	LocalDate getPaymentDeadline();

	LocalDate getPublishStartDate();

	LocalDate getPublishEndDate();

	String getSchoolId();

	LocationTourPublic getLocationTour();
}
