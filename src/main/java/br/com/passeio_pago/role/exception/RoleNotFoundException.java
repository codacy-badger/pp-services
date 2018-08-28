package br.com.passeio_pago.role.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.role.util.RoleConstants;

/**
 * The user was not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends ElementNotFoundException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2252748099956987502L;

	public RoleNotFoundException() {
		super(RoleConstants.ERROR_ROLE_NOT_FOUND);
	}

	public RoleNotFoundException(String message) {
		super(message);
	}
}
