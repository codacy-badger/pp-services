/**
 * 
 */
package br.com.passeio_pago;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author danilo-moreira
 *
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@Profile(value = { "!test" })
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Value("${info.app.version}")
	private String appVersion;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.consumes(Stream.of("application/json").collect(Collectors.toSet()))
				.produces(Stream.of("application/json").collect(Collectors.toSet()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API Passeio Pago")
				.description("Web Services do Passeio Pago.")
				.version(appVersion)
				.termsOfServiceUrl("Clientes deste Web Service devem ter autoriza\u00E7\u00E3o para us\u00E1-lo.")
				.contact(new Contact("Danilo Fernandes Nascimento Moreira", "https://github.com/passeio-pago/pp-services/pulls", "danilo_f.moreira@yahoo.com.br"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");
		registry
			.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}