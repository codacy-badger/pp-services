package br.com.passeio_pago.module.user.domain.dto;

import br.com.passeio_pago.module.common.domain.SingleValueDto;
import io.swagger.annotations.ApiModel;

/**
 * Response from the registration form.
 */
@ApiModel
public class UserRegistrationResponseDto<T> extends SingleValueDto<T> {

	public UserRegistrationResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegistrationResponseDto(T value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

}
