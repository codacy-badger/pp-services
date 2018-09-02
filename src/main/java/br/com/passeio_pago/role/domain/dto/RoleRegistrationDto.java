package br.com.passeio_pago.role.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RoleRegistrationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187403500327722202L;

	@ApiModelProperty(required = true, example = "parent", value = "Property to define account's role. This value must be unique.", allowableValues = "parent, teacher, both", allowEmptyValue = false)
	@NotBlank
	@Size(max = 100)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
