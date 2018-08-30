package br.com.passeio_pago.location_tour.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.service.EntityCrudService;
import br.com.passeio_pago.location_tour.dao.LocationTourDao;
import br.com.passeio_pago.location_tour.domain.LocationTourPublic;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourPublicDto;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourRegistrationDto;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourRegistrationResponseDto;
import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;

@Service
public class LocationTourService extends EntityCrudService<LocationTourEntity, Long, LocationTourPublicDto, LocationTourRegistrationDto, LocationTourRegistrationResponseDto> {

	@Autowired
	private LocationTourDao dao;

	@Override
	public JpaRepository<LocationTourEntity, Long> getDao() {
		return dao;
	}

	@Override
	public LocationTourRegistrationResponseDto convertPublicDtoToRegistrationResponseDto(LocationTourPublicDto publicDto) {
		LocationTourRegistrationResponseDto responseDto = new LocationTourRegistrationResponseDto(publicDto);
		return responseDto;
	}

	@Override
	public LocationTourEntity convertRegistrationDtoToEntityDao(LocationTourRegistrationDto registrationDto) {
		LocationTourEntity entity = new LocationTourEntity();
		BeanUtils.copyProperties(registrationDto, entity);
		return entity;
	}

	@Override
	public void validateRegistrationDto(LocationTourRegistrationDto registrationDto) {
	}

	@Override
	public LocationTourPublicDto convertEntityDaoToPublicDto(LocationTourEntity entity) {
		LocationTourPublicDto publicDto = new LocationTourPublicDto((LocationTourPublic) entity);
		return publicDto;
	}

}
