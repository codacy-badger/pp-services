package br.com.passeio_pago.tour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.passeio_pago.tour.domain.entity.TourEntity;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {

	List<TourEntity> findAllBySchoolId(String schoolId);

}
