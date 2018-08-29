package br.com.passeio_pago.account.domain.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.passeio_pago.account.domain.AccountPublic;
import br.com.passeio_pago.role.domain.RolePublic;
import io.swagger.annotations.ApiModel;

@ApiModel
public class AccountPublicDto implements AccountPublic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3430129304606583961L;
	private Long id;
	private String name;
	private String login;
	private String password;
	private String contact;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createdOn;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime lastLogin;
	private RolePublic role;

	public AccountPublicDto() {
		super();
	}

	public AccountPublicDto(AccountPublic account) {
		this(account.getId(), account.getName(), account.getLogin(), account.getPassword(), account.getContact(), account.getCreatedOn(), account.getLastLogin(), account.getRole());
	}

	public AccountPublicDto(Long id, String name, String login, String password, String contact, LocalDateTime createdOn, LocalDateTime lastLogin, RolePublic role) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.contact = contact;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.role = role;
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
	public String getLogin() {
		return login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getContact() {
		return contact;
	}

	@Override
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	@Override
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	@Override
	public RolePublic getRole() {
		return role;
	}

}
