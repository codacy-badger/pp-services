package br.com.passeio_pago.teste.commons;

import java.util.List;

public interface SimpleCrudService<DTO, ID> {

	List<DTO> getAll();

	DTO register(DTO t);

	void deleteById(ID id);

	DTO findByID(ID id);

}
