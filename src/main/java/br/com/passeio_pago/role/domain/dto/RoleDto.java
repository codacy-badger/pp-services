package br.com.passeio_pago.role.domain.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel
public class RoleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9111365813428196862L;
	private Long id;
	private String name;

	public RoleDto() {
		this(null);
	}

	public RoleDto(String name) {
		this(null, name);
	}

	public RoleDto(Long id, String name) {
		super();
		setId(id);
		setName(name);
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

}
