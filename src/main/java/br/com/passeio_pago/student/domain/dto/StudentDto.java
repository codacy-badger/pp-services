package br.com.passeio_pago.student.domain.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel
public class StudentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1311058867152508417L;

	private String registrationId;
	private String schoolId;
	private String firstName;
	private String lastName;
	private String schoolGrade;
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
