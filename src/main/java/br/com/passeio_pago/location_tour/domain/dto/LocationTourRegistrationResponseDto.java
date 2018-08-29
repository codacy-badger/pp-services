package br.com.passeio_pago.location_tour.domain.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class LocationTourRegistrationResponseDto {

	private LocationTourPublicDto locationTour;

	public LocationTourRegistrationResponseDto() {
		super();
	}

	public LocationTourPublicDto getAccount() {
		return locationTour;
	}

	public void setAccount(LocationTourPublicDto account) {
		this.locationTour = account;
	}

}
