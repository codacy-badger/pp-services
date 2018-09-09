package br.com.passeio_pago.student_tour.domain.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel
public class StudentTourDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8154439661020113805L;
	private Long tourId;
	private String schoolId;
	private String studentId;
	private Boolean paid;

	public Long getTourId() {
		return tourId;
	}

	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}

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

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

}
