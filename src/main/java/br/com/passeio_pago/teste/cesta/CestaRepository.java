package br.com.passeio_pago.teste.cesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CestaRepository extends JpaRepository<CestaEntity, Long> {

}
