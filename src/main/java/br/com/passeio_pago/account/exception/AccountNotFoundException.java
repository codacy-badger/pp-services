package br.com.passeio_pago.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.passeio_pago.account.util.AccountConstants;

/**
 * The user was not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4413858812132527403L;

	public AccountNotFoundException() {
		super(AccountConstants.ERROR_ACCOUNT_NOT_FOUND);
	}

	public AccountNotFoundException(String message) {
		super(message);
	}
}
