package br.com.passeio_pago.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.passeio_pago.role.domain.entity.RoleEntity;

@Repository
public interface RoleDao extends JpaRepository<RoleEntity, Long> {

}
