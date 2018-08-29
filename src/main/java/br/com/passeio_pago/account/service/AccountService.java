package br.com.passeio_pago.account.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.passeio_pago.account.dao.AccountDao;
import br.com.passeio_pago.account.domain.AccountPublic;
import br.com.passeio_pago.account.domain.dto.AccountPublicDto;
import br.com.passeio_pago.account.domain.dto.AccountRegistrationDto;
import br.com.passeio_pago.account.domain.dto.AccountRegistrationResponseDto;
import br.com.passeio_pago.account.domain.entity.AccountEntity;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.service.EntityCrudService;
import br.com.passeio_pago.role.domain.entity.RoleEntity;

@Service
public class AccountService extends EntityCrudService<AccountEntity, Long, AccountPublicDto, AccountRegistrationDto, AccountRegistrationResponseDto> {

	@Autowired
	private AccountDao dao;

	@Override
	public AccountRegistrationResponseDto convertPublicDtoToRegistrationResponseDto(AccountPublicDto publicDto) {
		AccountRegistrationResponseDto responseDto = new AccountRegistrationResponseDto(publicDto);
		return responseDto;
	}

	@Override
	public AccountEntity convertRegistrationDtoToEntityDao(AccountRegistrationDto registrationDto) {
		AccountEntity entity = new AccountEntity();
		BeanUtils.copyProperties(registrationDto, entity);
		entity.setRole(new RoleEntity(registrationDto.getRoleId()));
		entity.setLastLogin(LocalDateTime.now());
		return entity;
	}

	@Override
	public void validateRegistrationDto(AccountRegistrationDto registrationDto) {
		String password = registrationDto.getPassword();
		String repeatedPassword = registrationDto.getRepeatedPassword();
		if (!password.equals(repeatedPassword)) {
			throw new ElementRegistrationException("The passwords must be the same.");
		}
	}

	@Override
	public AccountPublicDto convertEntityDaoToPublicDto(AccountEntity entity) {
		AccountPublicDto publicDto = new AccountPublicDto((AccountPublic) entity);
		return publicDto;
	}

	@Override
	public JpaRepository<AccountEntity, Long> getDao() {
		return dao;
	}

}
