package br.com.passeio_pago.role.domain.dto;

import io.swagger.annotations.ApiModel;

/**
 * Response from the registration form.
 */
@ApiModel
public class RoleRegistrationResponseDto {

	private RolePublicDto role;

	public RoleRegistrationResponseDto() {
		super();
	}

	public RoleRegistrationResponseDto(RolePublicDto rolePublicDto) {
		this.role = rolePublicDto;
	}

	public RolePublicDto getRole() {
		return role;
	}

}
