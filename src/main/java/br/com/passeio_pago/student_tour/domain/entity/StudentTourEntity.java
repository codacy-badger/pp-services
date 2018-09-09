package br.com.passeio_pago.student_tour.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "student_tour")
@IdClass(StudentTourEntityPK.class)
public class StudentTourEntity {

	@Id
	@Column(name = "tour_id", nullable = false)
	private Long tourId;

	@Id
	@Column(name = "student_id", nullable = false, length = 20)
	private String studentId;

	@Id
	@Column(name = "school_id", nullable = false, length = 100)
	private String schoolId;

	public Long getTourId() {
		return tourId;
	}

	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

}
