package br.com.passeio_pago.common.service;

import java.util.List;

interface SimpleCrudService<DTO, ID> {

	List<DTO> getAll();

	DTO register(DTO t);

	void deleteById(ID id);

	DTO findByID(ID id);

}
