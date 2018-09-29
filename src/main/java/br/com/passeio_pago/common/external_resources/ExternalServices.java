package br.com.passeio_pago.common.external_resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalServices {

	@Bean
	public String goQrCodeWebService() {
		return "https://api.qrserver.com/v1/create-qr-code/";
	}
	
	@Bean
	public String tcuWebServiceHost() {
		return "http://mobile-aceite.tcu.gov.br:80/";
	}

	@Bean
	public String tcuSchoolRestWebService() {
		return tcuWebServiceHost() + "nossaEscolaRS/rest/escolas/";
	}

	@Value("${GOOGLE_GEOCODE_KEY}")
	private String googleGeocodeKey;

	@Bean
	public String googleGeocodeWebService() {
		return "https://maps.googleapis.com/maps/api/geocode/json?key=" + googleGeocodeKey;
	}

}
