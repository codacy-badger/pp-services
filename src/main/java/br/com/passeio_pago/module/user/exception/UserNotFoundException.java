package br.com.passeio_pago.module.user.exception;

import br.com.passeio_pago.module.user.util.UserConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The user was not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException() {
    super(UserConstants.ERROR_USER_NOT_FOUND);
  }

  public UserNotFoundException(String message) {
    super(message);
  }
}
