package br.com.passeio_pago.module.user.domain.dto;

import io.swagger.annotations.ApiModel;

/**
 * Response from the registration form.
 */
@ApiModel
public class UserRegistrationResponseDto<T> {

	private T user;

	public UserRegistrationResponseDto() {
		// Intentionally empty.
	}

	public UserRegistrationResponseDto(T user) {
		this.user = user;
	}

	public T getUser() {
		return user;
	}

}
