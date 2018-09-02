package br.com.passeio_pago.location_tour.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;

@Repository
public interface LocationTourRepository extends JpaRepository<LocationTourEntity, Long> {

}
