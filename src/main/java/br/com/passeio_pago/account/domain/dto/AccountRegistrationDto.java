package br.com.passeio_pago.account.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AccountRegistrationDto {

	@ApiModelProperty(required = true, example = "Danilo Moreira", value = "Property to define user's full name. For example, Danilo Moreira, Renan Lima.")
	@NotBlank
	private String name;

	@ApiModelProperty(required = true, example = "danilo@email.com", value = "Property to define account's email login.")
	@NotBlank
	@Email
	private String login;

	@ApiModelProperty(required = true, example = "psw123", value = "Property to define account's password.")
	@NotBlank
	private String password;

	@ApiModelProperty(required = true, example = "psw123", value = "Property to validate the password.")
	@NotBlank
	private String repeatedPassword;

	@ApiModelProperty(required = false, example = "9993033828", value = "Property to define user's contact.")
	private String contact;

	@ApiModelProperty(required = true, example = "2", allowableValues = "1, 2, 3", value = "Property to define account's role. For example, 1 = parent, 2 = teacher or 3 = both.")
	@NotNull
	private Long roleId;

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

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
