package br.com.passeio_pago.account.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.passeio_pago.role.domain.RolePublic;

public interface AccountPublic extends Serializable {
	Long getId();

	String getName();

	String getLogin();

	String getPassword();

	String getContact();

	LocalDateTime getCreatedOn();

	LocalDateTime getLastLogin();

	RolePublic getRole();
}
