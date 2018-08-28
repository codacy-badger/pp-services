package br.com.passeio_pago.account.domain.dto;

import io.swagger.annotations.ApiModel;

/**
 * Response from the registration form.
 */
@ApiModel
public class AccountRegistrationResponseDto {

	private AccountPublicDto account;

	public AccountRegistrationResponseDto() {
		super();
	}

	public AccountRegistrationResponseDto(AccountPublicDto account) {
		this.account = account;
	}

	public AccountPublicDto getAccount() {
		return account;
	}

}
