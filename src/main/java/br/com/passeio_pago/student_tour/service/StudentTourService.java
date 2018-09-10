package br.com.passeio_pago.student_tour.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.service.SimpleAbstractCrudService;
import br.com.passeio_pago.student_tour.dao.StudentTourRepository;
import br.com.passeio_pago.student_tour.domain.dto.StudentTourDto;
import br.com.passeio_pago.student_tour.domain.entity.StudentTourEntity;
import br.com.passeio_pago.student_tour.domain.entity.StudentTourEntityPK;

@Service
public class StudentTourService extends SimpleAbstractCrudService<StudentTourDto, StudentTourEntityPK, StudentTourEntity> {

	@Autowired
	private StudentTourRepository dao;

	@Override
	protected StudentTourDto mapEntityToDto(StudentTourEntity entity) {
		StudentTourDto dto = new StudentTourDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	protected StudentTourEntity mapDtoToEntity(StudentTourDto dto) {
		StudentTourEntity entity = new StudentTourEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	protected JpaRepository<StudentTourEntity, StudentTourEntityPK> getDao() {
		return dao;
	}

	public List<StudentTourDto> getAllStudentsByTourId(Long tourId) {
		return dao.findAllByTourId(tourId).stream().map(entity -> mapEntityToDto(entity)).collect(Collectors.toList());
	}

	public StudentTourDto payTour(Long tourId, String studentId, String schoolId) {
		StudentTourEntity entity = new StudentTourEntity();
		entity.setPaid(Boolean.TRUE);
		entity.setSchoolId(schoolId);
		entity.setStudentId(studentId);
		entity.setTourId(tourId);
		return mapEntityToDto(dao.save(entity));
	}

}
