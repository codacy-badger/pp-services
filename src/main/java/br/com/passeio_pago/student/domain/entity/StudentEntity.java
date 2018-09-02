package br.com.passeio_pago.student.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@IdClass(StudentEntityPK.class)
public class StudentEntity {

	@Id
	@Column(name = "registration_id", nullable = false, length = 20)
	private String registrationId;

	@Id
	@Column(name = "school_id", nullable = false, length = 100)
	private String schoolId;

	@Column(name = "first_name", nullable = false, length = 200)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 200)
	private String lastName;

	@Column(name = "school_grade", nullable = true, length = 50)
	private String schoolGrade;

	@Column(name = "class", nullable = true, length = 50)
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
