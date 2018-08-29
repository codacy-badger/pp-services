package br.com.passeio_pago.student.domain.dto;

import br.com.passeio_pago.student.domain.StudentPublic;
import io.swagger.annotations.ApiModel;

@ApiModel
public class StudentPublicDto implements StudentPublic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1589162221633392510L;
	private String registrationId;
	private String schoolId;
	private String firstName;
	private String lastName;
	private String schoolGrade;
	private String classIdentifier;

	public StudentPublicDto() {
		super();
	}

	public StudentPublicDto(StudentPublic student) {
		this(student.getRegistrationId(), student.getSchoolId(), student.getFirstName(), student.getLastName(), student.getSchoolGrade(), student.getClassIdentifier());
	}

	public StudentPublicDto(String registrationId, String schoolId, String firstName, String lastName, String schoolGrade, String classIdentifier) {
		super();
		this.registrationId = registrationId;
		this.schoolId = schoolId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolGrade = schoolGrade;
		this.classIdentifier = classIdentifier;
	}

	@Override
	public String getRegistrationId() {
		return registrationId;
	}

	@Override
	public String getSchoolId() {
		return schoolId;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getSchoolGrade() {
		return schoolGrade;
	}

	@Override
	public String getClassIdentifier() {
		return classIdentifier;
	}

}
