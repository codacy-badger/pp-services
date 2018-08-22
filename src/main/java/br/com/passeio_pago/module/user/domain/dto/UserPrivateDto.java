package br.com.passeio_pago.module.user.domain.dto;

import java.time.LocalDateTime;

import br.com.passeio_pago.module.user.domain.UserPrivate;
import io.swagger.annotations.ApiModel;

/**
 * Returns user private information from the Rest controller.
 */
@ApiModel
public class UserPrivateDto implements UserPrivate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6950397690746926163L;
	private Integer userId;
	private String fullName;
	private String login;
	private String password;
	private String emails;
	private String phones;
	private LocalDateTime createdOn;
	private Integer accountRoleId;
	private LocalDateTime lastLogin;

	public UserPrivateDto(UserPrivate userPrivate) {
		this(userPrivate.getUserId(), userPrivate.getFullName(), userPrivate.getLogin(), userPrivate.getPassword(), userPrivate.getEmails(), userPrivate.getPhones(), userPrivate.getCreatedOn(),
				userPrivate.getAccountRoleId(), userPrivate.getLastLogin());
	}

	public UserPrivateDto() {
		super();
	}

	public UserPrivateDto(Integer userId, String fullName, String login, String password, String emails, String phones, LocalDateTime createdOn, Integer accountRoleId, LocalDateTime lastLogin) {
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

	@Override
	public Integer getUserId() {
		return userId;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public String getFullName() {
		return fullName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getEmails() {
		return emails;
	}

	@Override
	public String getPhones() {
		return phones;
	}

	@Override
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	@Override
	public Integer getAccountRoleId() {
		return accountRoleId;
	}

	@Override
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

}
