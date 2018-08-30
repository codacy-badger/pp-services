package br.com.passeio_pago.tour.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.service.EntityCrudService;
import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;
import br.com.passeio_pago.tour.dao.TourDao;
import br.com.passeio_pago.tour.domain.TourPublic;
import br.com.passeio_pago.tour.domain.dto.TourPublicDto;
import br.com.passeio_pago.tour.domain.dto.TourRegistrationDto;
import br.com.passeio_pago.tour.domain.dto.TourRegistrationResponseDto;
import br.com.passeio_pago.tour.domain.entity.TourEntity;

@Service
public class TourService extends EntityCrudService<TourEntity, Long, TourPublicDto, TourRegistrationDto, TourRegistrationResponseDto> {

	@Autowired
	private TourDao dao;

	@Override
	public JpaRepository<TourEntity, Long> getDao() {
		return dao;
	}

	@Override
	public TourRegistrationResponseDto convertPublicDtoToRegistrationResponseDto(TourPublicDto publicDto) {
		TourRegistrationResponseDto responseDto = new TourRegistrationResponseDto(publicDto);
		return responseDto;
	}

	@Override
	public TourEntity convertRegistrationDtoToEntityDao(TourRegistrationDto registrationDto) {
		TourEntity entity = new TourEntity();
		BeanUtils.copyProperties(registrationDto, entity);
		entity.setLocationTour(new LocationTourEntity(registrationDto.getLocationTourId()));
		return entity;
	}

	@Override
	public void validateRegistrationDto(TourRegistrationDto registrationDto) {
	}

	@Override
	public TourPublicDto convertEntityDaoToPublicDto(TourEntity entity) {
		TourPublicDto publicDto = new TourPublicDto((TourPublic) entity);
		return publicDto;
	}

}
