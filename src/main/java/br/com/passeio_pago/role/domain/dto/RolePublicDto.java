package br.com.passeio_pago.role.domain.dto;

import java.util.List;

import br.com.passeio_pago.account.domain.entity.AccountEntity;
import br.com.passeio_pago.role.domain.RolePublic;
import io.swagger.annotations.ApiModel;

/**
 * Returns Role public information from the Rest controller.
 */
@ApiModel
public class RolePublicDto implements RolePublic {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4032111441512678345L;
	private Long id;
	private String name;
	private List<AccountEntity> accounts;

	public RolePublicDto() {
		super();
	}

	public RolePublicDto(RolePublic role) {
		this(role.getId(), role.getName(), role.getAccounts());
	}
	
	public RolePublicDto(Long id, String name, List<AccountEntity> accounts) {
		this.id = id;
		this.name = name;
		this.accounts = accounts;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<AccountEntity> getAccounts() {
		return accounts;
	}

}
