package br.com.passeio_pago.role.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.passeio_pago.common.domain.PaginatedValuesDto;
import br.com.passeio_pago.role.dao.RoleDao;
import br.com.passeio_pago.role.domain.RolePublic;
import br.com.passeio_pago.role.domain.dto.RolePublicDto;
import br.com.passeio_pago.role.domain.dto.RoleRegistrationDto;
import br.com.passeio_pago.role.domain.dto.RoleRegistrationResponseDto;
import br.com.passeio_pago.role.domain.entity.RoleEntity;
import br.com.passeio_pago.role.exception.RoleNotFoundException;
import br.com.passeio_pago.role.exception.RoleRegistrationException;
import br.com.passeio_pago.role.service.RoleService;

/**
 * All the business logic is implemented in the service layer. It connects to
 * the dao layer to return data from database. The entity returned should be Dto
 * and not database entity directly, this allow to hide sensitive database
 * fields and customise the output.
 */
@Component
public class RoleServiceImpl implements RoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

	private RoleDao userDao;

	@Autowired
	public RoleServiceImpl(RoleDao userDao) {
		this.userDao = userDao;
	}

	// private void validateUserRegistration(RoleRegistrationDto userRegistration) {
	// // TODO: Validation code here.
	// }

	@Override
	public RoleRegistrationResponseDto registerRole(RoleRegistrationDto roleRegistrationDto) throws RoleRegistrationException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(ToStringBuilder.reflectionToString(roleRegistrationDto));
		}
		try {
			RoleEntity roleEntity = new RoleEntity(roleRegistrationDto.getName());
			RolePublic saved = userDao.save(roleEntity);
			RolePublicDto rolePublicDto = new RolePublicDto(saved);
			RoleRegistrationResponseDto roleRegistrationResponseDto = new RoleRegistrationResponseDto(rolePublicDto);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(ToStringBuilder.reflectionToString(roleRegistrationResponseDto));
			}
			return roleRegistrationResponseDto;
		} catch (Exception e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new RoleRegistrationException(String.format("This role, %s, already exists.", roleRegistrationDto.getName()));
		}
	}

	@Override
	public PaginatedValuesDto<RolePublicDto> findRolesByCriteria(String name, Integer pageSize, Integer pageNumber) {
		List<RolePublic> findAllByName = userDao.findByNameContainingIgnoreCase(name);
		List<RolePublicDto> collect = findAllByName.stream().map(item -> new RolePublicDto(item)).collect(Collectors.toList());
		PaginatedValuesDto<RolePublicDto> result = new PaginatedValuesDto<RolePublicDto>(collect, pageSize, pageNumber, false);
		return result;
	}

	@Override
	public RolePublicDto getRoleById(Long roleId) throws RoleNotFoundException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(roleId.toString());
		}
		try {
			RolePublic found = userDao.findById(roleId).get();
			return new RolePublicDto(found);
		} catch (Exception e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new RoleNotFoundException(String.format("No role with id %s was found.", roleId.toString()));
		}
	}

	@Override
	public boolean deleteRoleById(Long roleId) throws RoleNotFoundException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(roleId.toString());
		}
		try {
			userDao.deleteById(roleId);
			return true;
		} catch (Exception e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new RoleNotFoundException(String.format("No role with id %s was found.", roleId.toString()));
		}
	}
}
