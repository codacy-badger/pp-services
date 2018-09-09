package br.com.passeio_pago.student_tour.domain.entity;

import java.io.Serializable;

public class StudentTourEntityPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3011964443933551136L;

	private Long tourId;
	private String schoolId;
	private String studentId;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schoolId == null) ? 0 : schoolId.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((tourId == null) ? 0 : tourId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentTourEntityPK other = (StudentTourEntityPK) obj;
		if (schoolId == null) {
			if (other.schoolId != null)
				return false;
		} else if (!schoolId.equals(other.schoolId))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (tourId == null) {
			if (other.tourId != null)
				return false;
		} else if (!tourId.equals(other.tourId))
			return false;
		return true;
	}

}
