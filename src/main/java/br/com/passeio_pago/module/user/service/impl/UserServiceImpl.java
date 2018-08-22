package br.com.passeio_pago.module.user.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.passeio_pago.module.common.domain.PaginatedValuesDto;
import br.com.passeio_pago.module.common.util.MorePreconditions;
import br.com.passeio_pago.module.user.dao.UserDao;
import br.com.passeio_pago.module.user.domain.UserPrivate;
import br.com.passeio_pago.module.user.domain.UserPublic;
import br.com.passeio_pago.module.user.domain.dto.UserPublicDto;
import br.com.passeio_pago.module.user.domain.dto.UserRegistrationDto;
import br.com.passeio_pago.module.user.domain.dto.UserRegistrationResponseDto;
import br.com.passeio_pago.module.user.domain.entity.UserEntity;
import br.com.passeio_pago.module.user.exception.UserNotFoundException;
import br.com.passeio_pago.module.user.exception.UserRegistrationException;
import br.com.passeio_pago.module.user.service.UserService;

/**
 * All the business logic is implemented in the service layer. It connects to
 * the dao layer to return data from database. The entity returned should be Dto
 * and not database entity directly, this allow to hide sensitive database
 * fields and customise the output.
 */
@Component
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserRegistrationResponseDto<UserPrivate> registerUser(UserRegistrationDto userRegistrationDto) throws UserRegistrationException {
		try {
			validateUserRegistration(userRegistrationDto);
		} catch (Exception e) {
			logger.info("Error registering user.", e);
			throw new UserRegistrationException(e.getMessage(), e);
		}
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userRegistrationDto, userEntity);
		UserPrivate userPrivate = userDao.createUser(userEntity);
		UserRegistrationResponseDto<UserPrivate> response = new UserRegistrationResponseDto<UserPrivate>(userPrivate);
		logger.info(ToStringBuilder.reflectionToString(response));
		return response;
	}

	@Override
	public PaginatedValuesDto<UserPublicDto> findUsersByCriteria(String fullName, Integer pageSize, Integer pageNum) {
		MorePreconditions.checkPagination(pageSize, pageNum);
		Collection<UserPublic> entities = userDao.findUsersByCriteria(fullName, pageSize, pageNum);
		Collection<UserPublicDto> values = entities.stream().map(UserPublicDto::new).collect(Collectors.toList());
		boolean hasMore = userDao.countUsersByCriteria(fullName) > pageSize * pageNum;
		return new PaginatedValuesDto<>(values, pageNum, pageSize, hasMore);
	}

	@Override
	public UserPublicDto getUserById(String userId) throws UserNotFoundException {
		MorePreconditions.checkNotNullOrEmptyWithBadRequest(userId);
		return new UserPublicDto(userDao.getUserById(userId));
	}

	private void validateUserRegistration(UserRegistrationDto userRegistration) {
		String password = userRegistration.getPassword();
		String repeatedPassword = userRegistration.getRepeatedPassword();
		if (!password.equals(repeatedPassword)) {
			throw new UserRegistrationException("Passwords must be the same. However, " + password + " and " + repeatedPassword + " were written.");
		}
	}
}
