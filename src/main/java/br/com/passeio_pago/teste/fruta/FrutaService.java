package br.com.passeio_pago.teste.fruta;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.common.service.SimpleAbstractCrudService;
import br.com.passeio_pago.teste.cesta.CestaEntity;

@Service
public class FrutaService extends SimpleAbstractCrudService<FrutaDto, Long, FrutaEntity> {

	@Autowired
	private FrutaRepository dao;

	@Override
	protected FrutaDto mapEntityToDto(FrutaEntity entity) {
		FrutaDto dto = new FrutaDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setCestaId(entity.getCesta().getId());
		return dto;
	}

	@Override
	protected FrutaEntity mapDtoToEntity(FrutaDto dto) {
		FrutaEntity entity = new FrutaEntity();
		BeanUtils.copyProperties(dto, entity);
		CestaEntity cesta = new CestaEntity();
		cesta.setId(dto.getCestaId());
		entity.setCesta(cesta);
		return entity;
	}

	@Override
	protected JpaRepository<FrutaEntity, Long> getDao() {
		return dao;
	}

	public FrutaDto register(FrutaRegisterDto registerDto) {
		return register(new FrutaDto(registerDto.getNome(), registerDto.getCestaId()));
	}
}