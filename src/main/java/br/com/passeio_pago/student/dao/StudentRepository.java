package br.com.passeio_pago.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.passeio_pago.student.domain.entity.StudentEntity;
import br.com.passeio_pago.student.domain.entity.StudentEntityPK;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, StudentEntityPK> {

}
