package br.com.passeio_pago;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class PasseioPagoServiceApplication {

	private Logger logger = LoggerFactory.getLogger(PasseioPagoServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PasseioPagoServiceApplication.class, args);
	}

	@Bean
	@Profile(value = { "staging", "production" })
	public BasicDataSource dataSource() {
		String dbUrl = System.getenv("SPRING_DATASOURCE_URL");
		String dbUserName = System.getenv("SPRING_DATASOURCE_USERNAME");
		String dbPassword = System.getenv("SPRING_DATASOURCE_PASSWORD");
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(dbUserName);
		basicDataSource.setPassword(dbPassword);
		if (logger.isDebugEnabled()) {
			logger.debug("dbUrl=" + dbUrl);
			logger.debug("dbUserName=" + dbUserName);
			logger.debug("dbPassword=" + dbPassword);
			logger.debug("dataSource=" + ToStringBuilder.reflectionToString(basicDataSource));
		}
		return basicDataSource;
	}
}
