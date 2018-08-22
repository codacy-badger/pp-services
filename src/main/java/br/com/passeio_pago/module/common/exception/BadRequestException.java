package br.com.passeio_pago.module.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Base exception for bad requests.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2398219889711498917L;

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String message, Throwable e) {
		super(message, e);
	}
}
