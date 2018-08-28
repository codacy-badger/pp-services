package br.com.passeio_pago.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ElementRegistrationException extends BadRequestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3805364902866028818L;

	public ElementRegistrationException(String message) {
		super(message);
	}

	public ElementRegistrationException(String message, Throwable e) {
		super(message, e);
	}

}
