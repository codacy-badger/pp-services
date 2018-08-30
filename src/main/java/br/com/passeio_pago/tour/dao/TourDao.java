package br.com.passeio_pago.tour.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.passeio_pago.tour.domain.entity.TourEntity;

@Repository
public interface TourDao extends JpaRepository<TourEntity, Long> {

}
