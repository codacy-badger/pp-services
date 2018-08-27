package br.com.passeio_pago.role.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.passeio_pago.common.exception.BadRequestException;

/**
 * User registration exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RoleRegistrationException extends BadRequestException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8604561643241945001L;

	public RoleRegistrationException(String message) {
		super(message);
	}

	public RoleRegistrationException(String message, Throwable e) {
		super(message, e);
	}
}
