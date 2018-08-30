package br.com.passeio_pago.student.domain.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class StudentRegistrationDto {

	@ApiModelProperty(required = true, example = "RM73683", value = "Property to define the student's id.")
	@NotBlank
	private String registrationId;
	
	@ApiModelProperty(required = true, example = "SC76263783232", value = "Property to define the school's id.")
	@NotBlank
	private String schoolId;
	
	@ApiModelProperty(required = true, example = "Danilo", value = "Property to define the student's first name.")
	@NotBlank
	private String firstName;

	@ApiModelProperty(required = true, example = "Moreira", value = "Property to define the student's last name.")
	@NotBlank
	private String lastName;

	@ApiModelProperty(required = true, example = "3ª série B", value = "Property to define the student's grade.")
	@NotBlank
	private String schoolGrade;

	@ApiModelProperty(required = true, example = "6", value = "Property to define the student's number class.")
	@NotBlank
	private String classIdentifier;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(String schoolGrade) {
		this.schoolGrade = schoolGrade;
	}

	public String getClassIdentifier() {
		return classIdentifier;
	}

	public void setClassIdentifier(String classIdentifier) {
		this.classIdentifier = classIdentifier;
	}

}
