package br.com.passeio_pago.module.user.domain.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Registration form for a new user.
 */
@ApiModel
public class UserRegistrationDto {

	@ApiModelProperty(required = true, example = "Renan Lima")
	private String fullName;

	@ApiModelProperty(required = true, example = "foo@email.com")
	@Email(message = "login must be a valid e-mail.")
	private String login;

	@ApiModelProperty(required = true, example = "renan123")
	private String password;

	@ApiModelProperty(required = true, example = "renan123")
	private String repeatedPassword;

	@ApiModelProperty(required = false, example = "foo@email.com|chill@email.com|lofi@email.com")
	private String emails;

	@ApiModelProperty(required = false, example = "1141000172|1141684381")
	private String phones;

	@ApiModelProperty(required = true, example = "1(teacher), 2(parent), 3(both)")
	@Range(min = 1, max = 3, message = "This field must be between 1 and 3, inclusive.")
	private int accountRoleId;

	public UserRegistrationDto() {
		super();
	}

	public UserRegistrationDto(String fullName, @Email(message = "login must be a valid e-mail.") String login, String password, String repeatedPassword, String emails, String phones,
			@Range(min = 1, max = 3, message = "This field must be between 1 and 3, inclusive.") int accountRoleId) {
		super();
		this.fullName = fullName;
		this.login = login;
		this.password = password;
		this.repeatedPassword = repeatedPassword;
		this.emails = emails;
		this.phones = phones;
		this.accountRoleId = accountRoleId;
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

	public int getAccountRoleId() {
		return accountRoleId;
	}

	public void setAccountRoleId(int accountRoleId) {
		this.accountRoleId = accountRoleId;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

}
