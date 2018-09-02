package br.com.passeio_pago.common.controlle;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

public interface SimpleCrudCrontroller<DTO, ID, REGISTER_DTO> {

	Resources<DTO> getAll();

	Resource<DTO> register(REGISTER_DTO dto);

	ResponseEntity<Object> deleteById(ID id);

	DTO findByID(ID id);

}