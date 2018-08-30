package br.com.passeio_pago.location_tour.domain.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class LocationTourRegistrationResponseDto {

	private LocationTourPublicDto locationTour;

	public LocationTourRegistrationResponseDto() {
		super();
	}

	public LocationTourRegistrationResponseDto(LocationTourPublicDto locationTour) {
		super();
		this.locationTour = locationTour;
	}

	public LocationTourPublicDto getLocationTour() {
		return locationTour;
	}

}
