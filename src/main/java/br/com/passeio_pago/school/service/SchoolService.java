package br.com.passeio_pago.school.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.school.domain.dto.School;

@Service
public class SchoolService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private String tcuSchoolRestWebService;

	public void getSchoolsById(String id) {

	}

	public void getSchoolsInTheArea(String id) {

	}

	public School[] getSchools(String nome, String rede, String municipio, String uf, String esferaAdministrativa) {
		try {
			URI uri = new URI(buildUri(nome, rede, municipio, uf, esferaAdministrativa));
			School[] listOfSchools = restTemplate.getForObject(uri, School[].class);
			Stream.of(listOfSchools).forEach(school -> {
				String href = school.getLinks()[0].getHref();
				String substring = href.substring(59);
				school.getLinks()[0].setHref(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString() + substring);
			});
			return listOfSchools;
		} catch (Exception e) {
			throw new ElementNotFoundException();
		}
	}

	public String buildUri(String nome, String rede, String municipio, String uf, String esferaAdministrativa) throws UnsupportedEncodingException {
		Map<String, Object> schoolUriVariables = getSchoolUriVariablesToSearch(nome, rede, municipio, uf, esferaAdministrativa);
		String stringQuery = schoolUriVariables.toString();
		stringQuery = StringUtils.replace(stringQuery, "{", "");
		stringQuery = StringUtils.replace(stringQuery, "}", "");
		stringQuery = StringUtils.replace(stringQuery, ", ", "&");
		return tcuSchoolRestWebService + "?" + stringQuery;
	}

	public Map<String, Object> getSchoolUriVariablesToSearch(String nome, String rede, String municipio, String uf, String esferaAdministrativa) throws UnsupportedEncodingException {
		Map<String, Object> uriVariables = new HashMap<String, Object>();
		if (!StringUtils.isBlank(nome)) {
			uriVariables.put("nome", URLEncoder.encode(nome.toUpperCase(), StandardCharsets.UTF_8.toString()));
		}
		if (!StringUtils.isBlank(rede)) {
			uriVariables.put("rede", URLEncoder.encode(rede, StandardCharsets.UTF_8.toString()));
		}
		if (!StringUtils.isBlank(municipio)) {
			uriVariables.put("municipio", URLEncoder.encode(municipio, StandardCharsets.UTF_8.toString()));
		}
		if (!StringUtils.isBlank(uf)) {
			uriVariables.put("uf", URLEncoder.encode(uf, StandardCharsets.UTF_8.toString()));
		}
		uriVariables.put("situacaoFuncionamento", URLEncoder.encode("Em Atividade", StandardCharsets.UTF_8.toString()));
		if (!StringUtils.isBlank(esferaAdministrativa)) {
			uriVariables.put("esferaAdministrativa", URLEncoder.encode(esferaAdministrativa, StandardCharsets.UTF_8.toString()));
		}
		uriVariables.put("campos", getSchoolFildsToBeReturned());
		uriVariables.put("quantidadeDeItens", 50);
		return uriVariables;
	}

	private Object getSchoolFildsToBeReturned() {
		String fields[] = new String[] { "codEscola", "cnpj", "nome", "rede", "esferaAdministrativa", "tipoConvenioPoderPublico", "email", "telefone", "urlWebSite", "links", "endereco", "zona" };
		String toString = Arrays.toString(fields);
		toString = StringUtils.remove(toString, "[");
		toString = StringUtils.remove(toString, "]");
		toString = StringUtils.remove(toString, " ");
		return toString;
	}
}
