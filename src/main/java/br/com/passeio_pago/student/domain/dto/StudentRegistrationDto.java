package br.com.passeio_pago.student.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class StudentRegistrationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1135060914492880990L;

	@ApiModelProperty(required = true, example = "RM73683", value = "Property to define the student's id.")
	@NotBlank
	@Size(max = 20)
	private String registrationId;

	@ApiModelProperty(required = true, example = "SC76263783232", value = "Property to define the school's id.")
	@NotBlank
	@Size(max = 100)
	private String schoolId;

	@ApiModelProperty(required = true, example = "Leandro", value = "Property to define the student's first name.")
	@NotBlank
	@Size(max = 200)
	private String firstName;

	@ApiModelProperty(required = true, example = "Santos", value = "Property to define the student's last name.")
	@NotBlank
	@Size(max = 200)
	private String lastName;

	@ApiModelProperty(required = false, example = "3 SERIE FUNDAMENTAL", value = "Property to define the student's grade.")
	@Size(max = 50)
	private String schoolGrade;

	@ApiModelProperty(required = false, example = "B", value = "Property to define the student's number class.")
	@Size(max = 50)
	private String classIdentifier;

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

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
