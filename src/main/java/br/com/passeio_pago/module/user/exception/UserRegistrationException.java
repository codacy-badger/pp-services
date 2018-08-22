package br.com.passeio_pago.module.user.exception;

import br.com.passeio_pago.module.common.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * User registration exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserRegistrationException extends BadRequestException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5771911480098129381L;

	public UserRegistrationException(String message) {
		super(message);
	}

	public UserRegistrationException(String message, Throwable e) {
		super(message, e);
	}
}
