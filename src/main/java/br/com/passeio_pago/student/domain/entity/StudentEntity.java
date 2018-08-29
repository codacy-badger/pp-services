package br.com.passeio_pago.student.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.passeio_pago.student.domain.StudentPublic;

@Entity
@Table(name = "student")
@IdClass(StudentEntityPK.class)
public class StudentEntity implements StudentPublic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1636369575084569684L;

	@Id
	@Column(name = "registration_id", nullable = false)
	private String registrationId;

	@Id
	@Column(name = "school_id", nullable = false)
	private String schoolId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "school_grade", nullable = false)
	private String schoolGrade;

	@Column(name = "class", nullable = false)
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
