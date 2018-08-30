package br.com.passeio_pago.student.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.service.EntityCrudService;
import br.com.passeio_pago.student.dao.StudentDao;
import br.com.passeio_pago.student.domain.StudentPublic;
import br.com.passeio_pago.student.domain.dto.StudentPublicDto;
import br.com.passeio_pago.student.domain.dto.StudentRegistrationDto;
import br.com.passeio_pago.student.domain.dto.StudentRegistrationResponseDto;
import br.com.passeio_pago.student.domain.entity.StudentEntity;
import br.com.passeio_pago.student.domain.entity.StudentEntityPK;

@Service
public class StudentService extends EntityCrudService<StudentEntity, StudentEntityPK, StudentPublicDto, StudentRegistrationDto, StudentRegistrationResponseDto> {

	@Autowired
	private StudentDao dao;

	@Override
	public StudentRegistrationResponseDto convertPublicDtoToRegistrationResponseDto(StudentPublicDto publicDto) {
		StudentRegistrationResponseDto responseDto = new StudentRegistrationResponseDto(publicDto);
		return responseDto;
	}

	@Override
	public StudentEntity convertRegistrationDtoToEntityDao(StudentRegistrationDto registrationDto) {
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(registrationDto, entity);
		return entity;
	}

	@Override
	public void validateRegistrationDto(StudentRegistrationDto registrationDto) {
	}

	@Override
	public StudentPublicDto convertEntityDaoToPublicDto(StudentEntity entity) {
		StudentPublicDto publicDto = new StudentPublicDto((StudentPublic) entity);
		return publicDto;
	}

	@Override
	public JpaRepository<StudentEntity, StudentEntityPK> getDao() {
		return dao;
	}

}
