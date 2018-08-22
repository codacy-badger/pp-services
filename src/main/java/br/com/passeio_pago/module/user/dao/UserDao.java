package br.com.passeio_pago.module.user.dao;

import java.util.Collection;

import br.com.passeio_pago.module.user.domain.UserPrivate;
import br.com.passeio_pago.module.user.domain.UserPublic;
import br.com.passeio_pago.module.user.domain.entity.UserEntity;
import br.com.passeio_pago.module.user.exception.UserNotFoundException;

/**
 * A dao interface for User related methods.
 */
public interface UserDao {
	UserPrivate createUser(UserEntity userEntity);

	Collection<UserPublic> findUsersByCriteria(String fullName, Integer pageSize, Integer pageNum);

	long countUsersByCriteria(String fullName);

	UserPrivate getUserById(String id) throws UserNotFoundException;
}
