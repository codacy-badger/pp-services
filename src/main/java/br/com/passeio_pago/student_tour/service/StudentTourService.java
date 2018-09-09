package br.com.passeio_pago.student_tour.service;

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

}
