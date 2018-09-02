package br.com.passeio_pago.teste.cesta;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.service.SimpleAbstractCrudService;

@Service
public class CestaService extends SimpleAbstractCrudService<CestaDto, Long, CestaEntity> {

	@Autowired
	private CestaRepository dao;

	@Override
	protected CestaDto mapEntityToDto(CestaEntity entity) {
		CestaDto dto = new CestaDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	protected CestaEntity mapDtoToEntity(CestaDto dto) {
		CestaEntity entity = new CestaEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	protected JpaRepository<CestaEntity, Long> getDao() {
		return dao;
	}

	public CestaDto register(CestaRegisterDto registerDto) {
		return register(new CestaDto(registerDto.getCor()));
	}
}