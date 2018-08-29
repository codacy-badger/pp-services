package br.com.passeio_pago.role.domain.dto;

import br.com.passeio_pago.role.domain.RolePublic;
import io.swagger.annotations.ApiModel;

@ApiModel
public class RolePublicDto implements RolePublic {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4032111441512678345L;
	private Long id;
	private String name;

	public RolePublicDto() {
		super();
	}

	public RolePublicDto(RolePublic role) {
		this(role.getId(), role.getName());
	}

	public RolePublicDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

}
