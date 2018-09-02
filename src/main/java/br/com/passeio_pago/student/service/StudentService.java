package br.com.passeio_pago.student.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.service.SimpleAbstractCrudService;
import br.com.passeio_pago.student.dao.StudentRepository;
import br.com.passeio_pago.student.domain.dto.StudentDto;
import br.com.passeio_pago.student.domain.dto.StudentRegistrationDto;
import br.com.passeio_pago.student.domain.entity.StudentEntity;
import br.com.passeio_pago.student.domain.entity.StudentEntityPK;

@Service
public class StudentService extends SimpleAbstractCrudService<StudentDto, StudentEntityPK, StudentEntity> {

	@Autowired
	private StudentRepository dao;

	@Override
	protected StudentDto mapEntityToDto(StudentEntity entity) {
		StudentDto dto = new StudentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	protected StudentEntity mapDtoToEntity(StudentDto dto) {
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	protected JpaRepository<StudentEntity, StudentEntityPK> getDao() {
		return dao;
	}

	public StudentDto register(StudentRegistrationDto registerDto) throws ElementRegistrationException {
		StudentDto dto = new StudentDto();
		BeanUtils.copyProperties(registerDto, dto);
		return register(dto);
	}
}
