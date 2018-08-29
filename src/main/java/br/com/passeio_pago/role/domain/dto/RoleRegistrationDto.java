package br.com.passeio_pago.role.domain.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RoleRegistrationDto {

	@ApiModelProperty(required = true, example = "parent", value = "Property to define user's role. For example, parent, teacher or both.", allowableValues="parent, teacher, both")
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
