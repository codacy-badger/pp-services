package br.com.passeio_pago.location_tour.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.service.SimpleAbstractCrudService;
import br.com.passeio_pago.location_tour.dao.LocationTourRepository;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourDto;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourRegistrationDto;
import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;

@Service
public class LocationTourService extends SimpleAbstractCrudService<LocationTourDto, Long, LocationTourEntity> {

	@Autowired
	private LocationTourRepository dao;

	@Override
	protected LocationTourDto mapEntityToDto(LocationTourEntity entity) {
		LocationTourDto dto = new LocationTourDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	protected LocationTourEntity mapDtoToEntity(LocationTourDto dto) {
		LocationTourEntity entity = new LocationTourEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	protected JpaRepository<LocationTourEntity, Long> getDao() {
		return dao;
	}

	public LocationTourDto register(LocationTourRegistrationDto registerDto) throws ElementRegistrationException {
		LocationTourDto locationTourDto = new LocationTourDto();
		BeanUtils.copyProperties(registerDto, locationTourDto);
		return register(locationTourDto);
	}
}
