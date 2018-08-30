package br.com.passeio_pago.student.domain.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class StudentRegistrationResponseDto {

	private StudentPublicDto student;

	public StudentRegistrationResponseDto() {
		super();
	}

	public StudentRegistrationResponseDto(StudentPublicDto student) {
		super();
		this.student = student;
	}

	public StudentPublicDto getStudent() {
		return student;
	}

}
