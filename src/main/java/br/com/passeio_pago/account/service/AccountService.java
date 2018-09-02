package br.com.passeio_pago.account.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.account.dao.AccountRepository;
import br.com.passeio_pago.account.domain.dto.AccountDto;
import br.com.passeio_pago.account.domain.dto.AccountRegistrationDto;
import br.com.passeio_pago.account.domain.entity.AccountEntity;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.service.SimpleAbstractCrudService;
import br.com.passeio_pago.role.domain.entity.RoleEntity;

@Service
public class AccountService extends SimpleAbstractCrudService<AccountDto, Long, AccountEntity> {

	@Autowired
	private AccountRepository dao;

	@Override
	protected AccountDto mapEntityToDto(AccountEntity entity) {
		AccountDto dto = new AccountDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setRoleId(entity.getRole().getId());
		return dto;
	}

	@Override
	protected AccountEntity mapDtoToEntity(AccountDto dto) {
		AccountEntity entity = new AccountEntity();
		BeanUtils.copyProperties(dto, entity);
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setId(dto.getRoleId());
		entity.setRole(roleEntity);
		return entity;
	}

	@Override
	protected JpaRepository<AccountEntity, Long> getDao() {
		return dao;
	}

	public AccountDto register(AccountRegistrationDto registerDto) throws ElementRegistrationException {
		validateUserRegistration(registerDto);
		AccountDto accountDto = new AccountDto();
		BeanUtils.copyProperties(registerDto, accountDto);
		return register(accountDto);
	}

	private void validateUserRegistration(AccountRegistrationDto registerDto) throws ElementRegistrationException {
		String password = registerDto.getPassword();
		String repeatedPassword = registerDto.getRepeatedPassword();
		if (!password.equals(repeatedPassword)) {
			throw new ElementRegistrationException("The passwords must be equals.");
		}
	}
}
