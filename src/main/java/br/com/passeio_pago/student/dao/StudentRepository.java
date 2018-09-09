package br.com.passeio_pago.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.passeio_pago.student.domain.entity.StudentEntity;
import br.com.passeio_pago.student.domain.entity.StudentEntityPK;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, StudentEntityPK> {

	@Query(nativeQuery = true, value = "SELECT * FROM student s WHERE (s.registration_id = ?2 or s.first_name = ?3 or s.last_name = ?4 or s.school_grade = ?5 or s.class = ?6) and s.school_id = ?1")
	List<StudentEntity> findStudentsWithSchoolIdAndParameter(String schoolId, String registrationId, String firstName, String lastName, String schoolGrade, String classIdentifier);

}
