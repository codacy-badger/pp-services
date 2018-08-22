package br.com.passeio_pago.module.user.domain.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class UserEntityRowMapper implements RowMapper<UserEntity> {

	private static final Logger logger = LoggerFactory.getLogger(UserEntityRowMapper.class);

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.info("rowNum = " + rowNum);
		UserEntity user = new UserEntity();
		user.setAccountRoleId(rs.getInt(UserEntityDefinition.ACCOUNTROLEID.getMeaning()));
		user.setCreatedOn(rs.getTimestamp(UserEntityDefinition.CREATEDON.getMeaning()).toLocalDateTime());
		user.setEmails(rs.getString(UserEntityDefinition.EMAILS.getMeaning()));
		user.setFullName(rs.getString(UserEntityDefinition.FULLNAME.getMeaning()));
		user.setLastLogin(rs.getTimestamp(UserEntityDefinition.LASTLOGIN.getMeaning()).toLocalDateTime());
		user.setLogin(rs.getString(UserEntityDefinition.LOGIN.getMeaning()));
		user.setPassword(rs.getString(UserEntityDefinition.PASSWORD.getMeaning()));
		user.setPhones(rs.getString(UserEntityDefinition.PHONES.getMeaning()));
		user.setUserId(rs.getInt(UserEntityDefinition.USERID.getMeaning()));
		logger.info(ToStringBuilder.reflectionToString(user));
		return user;
	}

}
