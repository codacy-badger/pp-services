package br.com.passeio_pago;

import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
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
	@Profile(value = { "devl", "prod" })
	public BasicDataSource dataSource() throws URISyntaxException {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
		basicDataSource.setUsername(System.getenv("SPRING_DATASOURCE_USERNAME"));
		basicDataSource.setPassword(System.getenv("SPRING_DATASOURCE_PASSWORD"));
		logger.debug("\n\ndebug");
		logger.info("\n\ninfo");
		logger.error("\n\nerror");
		logger.warn("\n\nwarn");
		return basicDataSource;
	}
}
