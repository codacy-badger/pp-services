package br.com.passeio_pago.common.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.util.CommonConstants;

public abstract class SimpleAbstractCrudService<DTO, ID, ENTITY> implements SimpleCrudService<DTO, ID> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleAbstractCrudService.class);

	@Override
	public List<DTO> getAll() {
		return getDao().findAll().stream().map(entity -> mapEntityToDto(entity)).collect(Collectors.toList());
	}

	@Override
	public DTO register(DTO dto) throws ElementRegistrationException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(dto.toString());
		}
		try {
			ENTITY entity = getDao().save(mapDtoToEntity(dto));
			DTO result = mapEntityToDto(entity);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(result.toString());
			}
			return result;
		} catch (DataIntegrityViolationException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			String message = CommonConstants.ERROR_REGISTRATION_ELEMENT;
			if (e.getMessage().contains("constraint [\"UK")) {
				message = "Unique constraint violate. This element already exists.";
			}
			if (e.getMessage().contains("constraint [\"FK")) {
				message = "Foreign key constraint violate. There are not relational element with this id.";
			}
			throw new ElementRegistrationException(message);
		}
	}

	@Override
	public void deleteById(ID id) throws BadRequestException, ElementNotFoundException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("id toString() = %s", id.toString()));
		}
		try {
			getDao().deleteById(id);
		} catch (IllegalArgumentException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new BadRequestException("id must not be null.");
		} catch (NoSuchElementException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new ElementNotFoundException(String.format("No such entity with id %s was found.", id.toString()));
		}
	}

	@Override
	public DTO findByID(ID id) throws BadRequestException, ElementNotFoundException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("id toString() = %s", id.toString()));
		}
		try {
			ENTITY entity = getDao().findById(id).get();
			return mapEntityToDto(entity);
		} catch (IllegalArgumentException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new BadRequestException("id must not be null.");
		} catch (NoSuchElementException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw new ElementNotFoundException(String.format("No such entity with id %s was found.", id.toString()));
		}
	}

	protected abstract DTO mapEntityToDto(ENTITY entity);

	protected abstract ENTITY mapDtoToEntity(DTO dto);

	protected abstract JpaRepository<ENTITY, ID> getDao();

}
