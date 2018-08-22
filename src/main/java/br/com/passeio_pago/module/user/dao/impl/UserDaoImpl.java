package br.com.passeio_pago.module.user.dao.impl;

import java.util.Collection;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;

import br.com.passeio_pago.module.common.dao.AbstractDao;
import br.com.passeio_pago.module.user.dao.UserDao;
import br.com.passeio_pago.module.user.domain.UserPrivate;
import br.com.passeio_pago.module.user.domain.UserPublic;
import br.com.passeio_pago.module.user.domain.entity.UserEntity;
import br.com.passeio_pago.module.user.domain.entity.UserEntityRowMapper;
import br.com.passeio_pago.module.user.exception.UserNotFoundException;
import br.com.passeio_pago.module.user.exception.UserRegistrationException;

/**
 * The user dao implementation.
 */
@Component
@PropertySource("classpath:jdbc.properties")
public class UserDaoImpl extends AbstractDao<UserEntity> implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	private Environment env;

	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate, Environment env) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.env = env;
	}

	@Override
	public UserPrivate createUser(UserEntity userEntity) {
		logger.info(ToStringBuilder.reflectionToString(userEntity));
		try {
			String sql = env.getProperty("sql.insertUser");
			jdbcTemplate.update(sql, userEntity.getFullName(), userEntity.getLogin(), userEntity.getPassword(), userEntity.getEmails(), userEntity.getPhones(), userEntity.getAccountRoleId());
		} catch (DataAccessException e) {
			logger.info("DataAccessException: " + e.getMessage());
			throw new UserRegistrationException(e.getMessage().substring(e.getMessage().lastIndexOf("ERROR: ") + 7));
		}
		UserPrivate userByLogin = getUserByLogin(userEntity.getLogin());
		logger.info(ToStringBuilder.reflectionToString(userByLogin));
		return userByLogin;
	}

	@Override
	public Collection<UserPublic> findUsersByCriteria(String fullName, Integer pageSize, Integer pageNum) {
		// TODO: Implement this method.
		return ImmutableList.of();
	}

	@Override
	public long countUsersByCriteria(String fullName) {
		// TODO: Implement this method.
		return 0;
	}

	@Override
	public UserPrivate getUserById(String id) throws UserNotFoundException {
		// TODO: Implement this method.
		throw new UserNotFoundException();
	}

	public UserPrivate getUserByLogin(String login) throws UserNotFoundException {
		logger.info("login searched: " + login);
		try {
			String sql = env.getProperty("query.findUserByLogin");
			UserEntity userEntity = jdbcTemplate.queryForObject(sql, new UserEntityRowMapper(), login);
			return userEntity;
		} catch (DataAccessException e) {
			logger.info("DataAccessException: " + e.getMessage());
			throw new UserNotFoundException(e.getMessage().substring(e.getMessage().lastIndexOf("ERROR: ") + 7));
		}
	}
}
