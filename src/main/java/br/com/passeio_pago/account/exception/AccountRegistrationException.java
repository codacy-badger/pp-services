package br.com.passeio_pago.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.passeio_pago.common.exception.BadRequestException;

/**
 * User registration exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountRegistrationException extends BadRequestException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8745121089568454647L;

	public AccountRegistrationException(String message) {
		super(message);
	}

	public AccountRegistrationException(String message, Throwable e) {
		super(message, e);
	}
}
