package br.com.passeio_pago.role.service;

import br.com.passeio_pago.common.domain.PaginatedValuesDto;
import br.com.passeio_pago.role.domain.dto.RolePublicDto;
import br.com.passeio_pago.role.domain.dto.RoleRegistrationDto;
import br.com.passeio_pago.role.domain.dto.RoleRegistrationResponseDto;
import br.com.passeio_pago.role.exception.RoleNotFoundException;
import br.com.passeio_pago.role.exception.RoleRegistrationException;

public interface RoleService {
	RoleRegistrationResponseDto registerRole(RoleRegistrationDto roleRegistrationDto) throws RoleRegistrationException;

	PaginatedValuesDto<RolePublicDto> findRolesByCriteria(String name, Integer pageSize, Integer pageNumber);

	RolePublicDto getRoleById(Long roleId) throws RoleNotFoundException;
	
	boolean deleteRoleById(Long roleId) throws RoleNotFoundException;
}
