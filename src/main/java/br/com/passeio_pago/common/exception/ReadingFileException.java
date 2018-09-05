package br.com.passeio_pago.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReadingFileException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4133119605173969653L;

	public ReadingFileException() {
		super();
	}

	public ReadingFileException(String message) {
		super(message);
	}

}
