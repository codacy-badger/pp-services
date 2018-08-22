package br.com.passeio_pago.module.user.domain.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class UserEntityRowMapper implements RowMapper<UserEntity> {

	private static final Logger logger = LoggerFactory.getLogger(UserEntityRowMapper.class);

	private UserEntityDefinition def;

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.debug("rowNum = " + rowNum);
		UserEntity user = new UserEntity();
		user.setAccountRoleId(rs.getInt(def.ACCOUNTROLEID.getMeaning()));
		user.setCreatedOn(rs.getTimestamp(def.CREATEDON.getMeaning()).toLocalDateTime());
		user.setEmails(rs.getString(def.EMAILS.getMeaning()));
		user.setFullName(rs.getString(def.FULLNAME.getMeaning()));
		user.setLastLogin(rs.getTimestamp(def.LASTLOGIN.getMeaning()).toLocalDateTime());
		user.setLogin(rs.getString(def.LOGIN.getMeaning()));
		user.setPassword(rs.getString(def.PASSWORD.getMeaning()));
		user.setPhones(rs.getString(def.PHONES.getMeaning()));
		user.setUserId(rs.getInt(def.USERID.getMeaning()));
		logger.debug(ToStringBuilder.reflectionToString(user));
		return user;
	}

}
