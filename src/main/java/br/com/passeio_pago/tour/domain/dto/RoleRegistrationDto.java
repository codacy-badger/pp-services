package br.com.passeio_pago.role.domain.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RoleRegistrationDto {

	@ApiModelProperty(required = true, example = "parent", value = "Property to define account's role. This value must be unique.", allowableValues = "parent, teacher, both", allowEmptyValue = false)
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
