package br.com.passeio_pago.common.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class SimpleAbstractCrudService<DTO, ID, ENTITY> implements SimpleCrudService<DTO, ID> {

	@Override
	public List<DTO> getAll() {
		return getDao().findAll().stream().map(entity -> mapEntityToDto(entity)).collect(Collectors.toList());
	}

	@Override
	public DTO register(DTO dto) {
		return mapEntityToDto(getDao().save(mapDtoToEntity(dto)));
	}

	@Override
	public void deleteById(ID id) {
		getDao().deleteById(id);
	}

	@Override
	public DTO findByID(ID id) {
		return mapEntityToDto(getDao().findById(id).get());
	}

	protected abstract DTO mapEntityToDto(ENTITY entity);

	protected abstract ENTITY mapDtoToEntity(DTO dto);

	protected abstract JpaRepository<ENTITY, ID> getDao();

}
