package br.com.passeio_pago.module.user.service;

import br.com.passeio_pago.module.common.domain.PaginatedValuesDto;
import br.com.passeio_pago.module.user.domain.UserPrivate;
import br.com.passeio_pago.module.user.domain.dto.UserPublicDto;
import br.com.passeio_pago.module.user.domain.dto.UserRegistrationDto;
import br.com.passeio_pago.module.user.domain.dto.UserRegistrationResponseDto;
import br.com.passeio_pago.module.user.exception.UserNotFoundException;
import br.com.passeio_pago.module.user.exception.UserRegistrationException;

public interface UserService {
	UserRegistrationResponseDto<UserPrivate> registerUser(UserRegistrationDto userRegistrationDto) throws UserRegistrationException;

	PaginatedValuesDto<UserPublicDto> findUsersByCriteria(String fullName, Integer pageSize, Integer pageNum);

	UserPublicDto getUserById(String userId) throws UserNotFoundException;
}
