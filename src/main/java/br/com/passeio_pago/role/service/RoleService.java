package br.com.passeio_pago.role.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.service.SimpleAbstractCrudService;
import br.com.passeio_pago.role.dao.RoleRepository;
import br.com.passeio_pago.role.domain.dto.RoleDto;
import br.com.passeio_pago.role.domain.dto.RoleRegistrationDto;
import br.com.passeio_pago.role.domain.entity.RoleEntity;

@Service
public class RoleService extends SimpleAbstractCrudService<RoleDto, Long, RoleEntity> {

	@Autowired
	private RoleRepository dao;

	@Override
	protected RoleDto mapEntityToDto(RoleEntity entity) {
		RoleDto dto = new RoleDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	protected RoleEntity mapDtoToEntity(RoleDto dto) {
		RoleEntity entity = new RoleEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	protected JpaRepository<RoleEntity, Long> getDao() {
		return dao;
	}

	public RoleDto register(RoleRegistrationDto registerDto) throws ElementRegistrationException {
		return register(new RoleDto(registerDto.getName()));
	}
}
