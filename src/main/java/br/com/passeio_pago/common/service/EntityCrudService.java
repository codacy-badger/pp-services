package br.com.passeio_pago.common.service;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;

public abstract class EntityCrudService<ENTITY, ENTITY_ID, PUBLIC_DTO, REGISTRATION_DTO, REGISTRATION_RESPONSE_DTO> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntityCrudService.class);

	public REGISTRATION_RESPONSE_DTO register(REGISTRATION_DTO registrationDto) throws ElementRegistrationException, BadRequestException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(registrationDto.toString());
		}
		try {
			validateRegistrationDto(registrationDto);
			ENTITY entity = getDao().save(convertRegistrationDtoToEntityDao(registrationDto));
			PUBLIC_DTO publicDto = convertEntityDaoToPublicDto(entity);
			REGISTRATION_RESPONSE_DTO registrationResponseDto = convertPublicDtoToRegistrationResponseDto(publicDto);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(registrationResponseDto.toString());
			}
			return registrationResponseDto;
		} catch (DataIntegrityViolationException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new ElementRegistrationException(e.getMessage());
		}
	}

	public abstract JpaRepository<ENTITY, ENTITY_ID> getDao();

	public abstract REGISTRATION_RESPONSE_DTO convertPublicDtoToRegistrationResponseDto(PUBLIC_DTO publicDto);

	public abstract ENTITY convertRegistrationDtoToEntityDao(REGISTRATION_DTO registrationDto);

	public abstract void validateRegistrationDto(REGISTRATION_DTO registrationDto);

	public Page<PUBLIC_DTO> findAll(Integer page, Integer size) {
		return getDao().findAll(PageRequest.of(page, size)).map(entity -> convertEntityDaoToPublicDto(entity));
	}

	public PUBLIC_DTO findById(ENTITY_ID entityId) throws ElementNotFoundException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("EntityId toString() = %s", entityId.toString()));
		}
		try {
			ENTITY entity = getDao().findById(entityId).get();
			return convertEntityDaoToPublicDto(entity);
		} catch (IllegalArgumentException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new BadRequestException("entityId must not be null.");
		} catch (NoSuchElementException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new ElementNotFoundException(String.format("No such entity with id %s was found.", entityId.toString()));
		}
	}

	public abstract PUBLIC_DTO convertEntityDaoToPublicDto(ENTITY entity);

	public boolean deleteById(ENTITY_ID entityId) throws ElementNotFoundException, BadRequestException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("EntityId toString() = %s", entityId.toString()));
		}
		try {
			getDao().deleteById(entityId);
			return true;
		} catch (IllegalArgumentException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new BadRequestException("entityId must not be null.");
		} catch (NoSuchElementException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new ElementNotFoundException(String.format("No such entity with id %s was found.", entityId.toString()));
		}
	}

}
