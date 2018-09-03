package br.com.passeio_pago;

import java.util.Locale;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import br.com.passeio_pago.file_handler.property.FileStorageProperties;

/**
 * @author danilo-moreira
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(value= {FileStorageProperties.class})
public class PasseioPagoServiceApplication {

	private Logger logger = LoggerFactory.getLogger(PasseioPagoServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PasseioPagoServiceApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pt", "BR"));
		logger.debug("localeResolver=" + ToStringBuilder.reflectionToString(localeResolver));
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages");
		logger.debug("messageSource=" + ToStringBuilder.reflectionToString(messageSource));
		return messageSource;
	}

}
