package br.com.passeio_pago.common.external_resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalServices {

	@Bean
	public String tcuWebServiceHost() {
		return "http://mobile-aceite.tcu.gov.br:80/";
	}

	@Bean
	public String tcuSchoolRestWebService() {
		return tcuWebServiceHost() + "nossaEscolaRS/rest/escolas/";
	}

}
