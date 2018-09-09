package br.com.passeio_pago.tour.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.service.SimpleAbstractCrudService;
import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;
import br.com.passeio_pago.student.domain.dto.StudentDto;
import br.com.passeio_pago.student.domain.entity.StudentEntityPK;
import br.com.passeio_pago.student.service.StudentService;
import br.com.passeio_pago.student_tour.domain.dto.StudentTourDto;
import br.com.passeio_pago.student_tour.service.StudentTourService;
import br.com.passeio_pago.tour.dao.TourRepository;
import br.com.passeio_pago.tour.domain.dto.LinkStudentsToTourRequestDto;
import br.com.passeio_pago.tour.domain.dto.TourDto;
import br.com.passeio_pago.tour.domain.dto.TourRegistrationDto;
import br.com.passeio_pago.tour.domain.entity.TourEntity;

@Service
public class TourService extends SimpleAbstractCrudService<TourDto, Long, TourEntity> {

	private static final Logger LOGGER = LoggerFactory.getLogger(TourService.class);

	@Autowired
	private TourRepository dao;

	@Autowired
	private StudentTourService studentTourService;

	@Autowired
	private StudentService studentService;

	@Override
	protected TourDto mapEntityToDto(TourEntity entity) {
		TourDto dto = new TourDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setLocationTourId(entity.getLocationTour().getId());
		return dto;
	}

	@Override
	protected TourEntity mapDtoToEntity(TourDto dto) {
		TourEntity entity = new TourEntity();
		BeanUtils.copyProperties(dto, entity);
		LOGGER.info(ToStringBuilder.reflectionToString(entity));
		LocationTourEntity locationTour = new LocationTourEntity();
		locationTour.setId(dto.getLocationTourId());
		entity.setLocationTour(locationTour);
		return entity;
	}

	@Override
	protected JpaRepository<TourEntity, Long> getDao() {
		return dao;
	}

	public TourDto register(TourRegistrationDto registerDto) throws ElementRegistrationException {
		TourDto dto = new TourDto();
		BeanUtils.copyProperties(registerDto, dto);
		return register(dto);
	}

	public List<StudentTourDto> linkStudentsToTour(Long tourId, LinkStudentsToTourRequestDto[] linkStudentsToTourRequestDto) {
		List<StudentTourDto> list = new ArrayList<StudentTourDto>();
		for (LinkStudentsToTourRequestDto item : linkStudentsToTourRequestDto) {
			StudentTourDto registerDto = new StudentTourDto();
			registerDto.setSchoolId(item.getSchoolId());
			registerDto.setStudentId(item.getStudentId());
			registerDto.setTourId(tourId);
			StudentTourDto register = studentTourService.register(registerDto);
			list.add(register);
		}
		return list;
	}

	public List<StudentDto> getAllStudentsByTourId(Long tourId) {
		return studentTourService.getAllStudentsByTourId(tourId).stream().map(item -> {
			StudentEntityPK id = new StudentEntityPK();
			id.setRegistrationId(item.getStudentId());
			return studentService.findByID(id);
		}).collect(Collectors.toList());
	}
}
