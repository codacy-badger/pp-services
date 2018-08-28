package br.com.passeio_pago.tour.domain.dto;

import io.swagger.annotations.ApiModel;

/**
 * Response from the registration form.
 */
@ApiModel
public class TourRegistrationResponseDto {

	private TourPublicDto account;

	public TourRegistrationResponseDto() {
		super();
	}

	public TourPublicDto getAccount() {
		return account;
	}

	public void setAccount(TourPublicDto account) {
		this.account = account;
	}

}
