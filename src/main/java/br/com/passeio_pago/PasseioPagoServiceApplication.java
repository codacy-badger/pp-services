package br.com.passeio_pago;

import java.util.Locale;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * @author danilo-moreira
 *
 */
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
			logger.info("dbUrl=" + dbUrl);
			logger.info("dbUserName=" + dbUserName);
			logger.info("dbPassword=" + dbPassword);
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(dbUserName);
		basicDataSource.setPassword(dbPassword);
		basicDataSource.setInitialSize(10);
		basicDataSource.setMinIdle(5);
		basicDataSource.setMaxTotal(20);
		basicDataSource.setPoolPreparedStatements(true);
		basicDataSource.setDriverClassName("org.postgresql.Driver");
		return basicDataSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pt", "BR"));
		if (logger.isDebugEnabled()) {
			logger.debug("localeResolver=" + ToStringBuilder.reflectionToString(localeResolver));
		}
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages");
		if (logger.isDebugEnabled()) {
			logger.debug("messageSource=" + ToStringBuilder.reflectionToString(messageSource));
		}
		return messageSource;
	}
}
