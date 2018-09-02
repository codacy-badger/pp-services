package br.com.passeio_pago.account.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;

@ApiModel
public class AccountDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3430129304606583961L;
	private Long id;
	private String name;
	private String login;
	private String password;
	private String phoneNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createdOn = LocalDateTime.now();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime lastLogin;
	private Long roleId;

	public AccountDto(String name, String login, String password, String phoneNumber, LocalDateTime createdOn, LocalDateTime lastLogin, Long roleId) {
		this(null, name, login, password, phoneNumber, createdOn, lastLogin, roleId);
	}

	public AccountDto() {
		super();
	}

	public AccountDto(Long id, String name, String login, String password, String phoneNumber, LocalDateTime createdOn, LocalDateTime lastLogin, Long roleId) {
		super();
		setId(id);
		setName(name);
		setLogin(login);
		setPassword(password);
		setPhoneNumber(phoneNumber);
		setCreatedOn(createdOn);
		setLogin(login);
		setRoleId(roleId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
