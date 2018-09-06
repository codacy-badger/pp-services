package br.com.passeio_pago.common.external_resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleResources {
	@Bean
	public List<String> addressComponentTypes() {
		return Arrays.asList(
				"street_number",
				"route",
				"sublocality_level_1",
				"administrative_area_level_2",
				"administrative_area_level_1",
				"country",
				"postal_code"
				);
	}
}
