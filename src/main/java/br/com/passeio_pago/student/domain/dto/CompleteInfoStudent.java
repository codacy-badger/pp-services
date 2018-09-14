package br.com.passeio_pago.student.domain.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CompleteInfoStudent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2147090031540444794L;
	private String studentId;
	private Boolean paid;
	private String firstName;
	private String lastName;
	private String schoolGrade;
	private String classIdentifier;

	public CompleteInfoStudent(StudentDto studentDto, Boolean paid) {
		this(studentDto.getRegistrationId(), paid, studentDto.getFirstName(), studentDto.getLastName(), studentDto.getSchoolGrade(), studentDto.getClassIdentifier());
	}

	public CompleteInfoStudent() {
		super();
	}

	public CompleteInfoStudent(String studentId, Boolean paid, String firstName, String lastName, String schoolGrade, String classIdentifier) {
		super();
		this.studentId = studentId;
		this.paid = paid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolGrade = schoolGrade;
		this.classIdentifier = classIdentifier;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
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
