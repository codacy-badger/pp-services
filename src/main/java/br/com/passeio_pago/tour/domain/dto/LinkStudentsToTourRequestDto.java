package br.com.passeio_pago.tour.domain.dto;

import java.io.Serializable;

public class LinkStudentsToTourRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7167090670096316256L;

	private String schoolId;
	private String studentId;

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}
