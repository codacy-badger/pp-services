package br.com.passeio_pago.role.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.passeio_pago.role.domain.RolePublic;
import br.com.passeio_pago.role.domain.entity.RoleEntity;

/**
 * A dao interface for Role related methods.
 */
@Repository
public interface RoleDao extends JpaRepository<RoleEntity, Long>{
	List<RolePublic> findByNameContainingIgnoreCase(String name);
}
