package br.com.passeio_pago.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.passeio_pago.common.util.CommonConstants;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5376173496243460699L;

	public ElementNotFoundException() {
		super(CommonConstants.ERROR_ELEMENT_NOT_FOUND);
	}

	public ElementNotFoundException(String message) {
		super(message);
	}
}
