package br.com.passeio_pago.tour.domain.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class TourRegistrationResponseDto {

	private TourPublicDto tour;

	public TourRegistrationResponseDto() {
		super();
	}

	public TourRegistrationResponseDto(TourPublicDto tour) {
		super();
		this.tour = tour;
	}

	public TourPublicDto getTour() {
		return tour;
	}

}
