package br.com.passeio_pago.student.domain.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class StudentRegistrationResponseDto {

	private StudentPublicDto student;

	public StudentRegistrationResponseDto() {
		super();
	}

	public StudentPublicDto getStudent() {
		return student;
	}

	public void setStudent(StudentPublicDto student) {
		this.student = student;
	}

}
