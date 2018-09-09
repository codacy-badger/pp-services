package br.com.passeio_pago.student_tour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.passeio_pago.student_tour.domain.entity.StudentTourEntity;
import br.com.passeio_pago.student_tour.domain.entity.StudentTourEntityPK;

@Repository
public interface StudentTourRepository extends JpaRepository<StudentTourEntity, StudentTourEntityPK> {

	List<StudentTourEntity> findAllByTourId(Long tourId);

}
