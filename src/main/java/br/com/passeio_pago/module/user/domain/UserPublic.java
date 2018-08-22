package br.com.passeio_pago.module.user.domain;

import java.io.Serializable;

public interface UserPublic extends Serializable {
	Integer getUserId();

	String getLogin();
}
