package br.com.passeio_pago.role.domain;

import java.io.Serializable;
import java.util.List;

import br.com.passeio_pago.account.domain.entity.AccountEntity;

public interface RolePublic extends Serializable {
	Long getId();

	String getName();

	List<AccountEntity> getAccounts();
}
