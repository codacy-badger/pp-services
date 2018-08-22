package br.com.passeio_pago.module.user.domain;

import java.time.LocalDateTime;

public interface UserPrivate extends UserPublic {
	String getFullName();

	String getPassword();

	String getEmails();

	String getPhones();

	LocalDateTime getCreatedOn();

	Integer getAccountRoleId();

	LocalDateTime getLastLogin();
}
