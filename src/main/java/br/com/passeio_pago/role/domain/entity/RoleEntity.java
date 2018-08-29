package br.com.passeio_pago.role.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.passeio_pago.account.domain.entity.AccountEntity;
import br.com.passeio_pago.role.domain.RolePublic;

@Entity
@Table(name = "role")
public class RoleEntity implements RolePublic {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4608676036956931925L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
	@SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence")
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
	private List<AccountEntity> accounts;

	public RoleEntity() {
		super();
	}
	
	public RoleEntity(Long id) {
		this.id = id;
	}

	public RoleEntity(String name) {
		this.name = name;
	}

	public RoleEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

}
