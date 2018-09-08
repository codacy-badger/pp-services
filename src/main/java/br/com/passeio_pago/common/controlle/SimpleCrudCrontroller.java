package br.com.passeio_pago.common.controlle;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;

public interface SimpleCrudCrontroller<DTO, ID, REGISTER_DTO> {

	List<Resource<DTO>> getAll();

	Resource<DTO> register(REGISTER_DTO dto);

	ResponseEntity<Object> deleteById(ID id);

	DTO findByID(ID id);

}