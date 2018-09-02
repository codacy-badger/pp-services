package br.com.passeio_pago.account.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.passeio_pago.common.util.CommonPatterns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AccountRegistrationDto {

	@ApiModelProperty(required = true, example = "Danilo Moreira", value = "Property to define account's full name.")
	@NotBlank
	private String name;

	@ApiModelProperty(required = true, example = "danilo@email.com", value = "Property to define account's email login. This value must be unique.")
	@NotBlank
	@Email
	private String login;

	@ApiModelProperty(required = true, example = "qwert@123", value = "Property to define account's password.")
	@NotBlank
	private String password;

	@ApiModelProperty(required = true, example = "qwert@123", value = "Property to validate the password.")
	@NotBlank
	private String repeatedPassword;

	@ApiModelProperty(required = false, example = "(11) 94100-0172", value = "Property to define account's contact.")
	@Pattern(regexp = CommonPatterns.PHONE_NUMBER_PATTERN)
	private String phoneNumber;

	@ApiModelProperty(required = true, example = "1", allowableValues = "1, 2, 3", value = "Property to define account's role.")
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
