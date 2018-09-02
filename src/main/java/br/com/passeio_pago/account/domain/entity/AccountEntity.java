package br.com.passeio_pago.account.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.passeio_pago.role.domain.entity.RoleEntity;

@Entity
@Table(name = "account")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
	@SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence")
	private Long id;

	@Column(name = "name", nullable = false, length = 400)
	private String name;

	@Column(name = "login", nullable = false, unique = true, length = 400)
	private String login;

	@Column(name = "password", nullable = false, length = 20)
	private String password;

	@Column(name = "phone_number", nullable = false, length = 30)
	private String phoneNumber;

	@Column(name = "created_on", nullable = false)
	private LocalDateTime createdOn = LocalDateTime.now();

	@Column(name = "last_login", nullable = true)
	private LocalDateTime lastLogin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	private RoleEntity role;

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

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

}
