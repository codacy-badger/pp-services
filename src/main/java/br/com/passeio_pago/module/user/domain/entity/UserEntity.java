package br.com.passeio_pago.module.user.domain.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.passeio_pago.module.user.domain.UserPrivate;

/**
 * Represents the object database mapping. It should be enriched with the
 * annotations related to the persistence framework, for example MongoDb,
 * Hibernate, etc.
 */
public class UserEntity implements UserPrivate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -386386441680015502L;

	private Integer userId;
	private String fullName;
	private String login;
	private String password;
	private String emails;
	private String phones;
	@PastOrPresent
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime createdOn;
	private Integer accountRoleId;
	@PastOrPresent
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime lastLogin;

	public UserEntity() {
		super();
	}

	public UserEntity(Integer userId, String fullName, String login, String password, String emails, String phones, LocalDateTime createdOn, Integer accountRoleId, LocalDateTime lastLogin) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.login = login;
		this.password = password;
		this.emails = emails;
		this.phones = phones;
		this.createdOn = createdOn;
		this.accountRoleId = accountRoleId;
		this.lastLogin = lastLogin;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getAccountRoleId() {
		return accountRoleId;
	}

	public void setAccountRoleId(Integer accountRoleId) {
		this.accountRoleId = accountRoleId;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

}
