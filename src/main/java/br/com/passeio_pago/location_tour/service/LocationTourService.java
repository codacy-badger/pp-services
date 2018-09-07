package br.com.passeio_pago.location_tour.service;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.service.SimpleAbstractCrudService;
import br.com.passeio_pago.location_tour.dao.LocationTourRepository;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourDto;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourRegistrationDto;
import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;

@Service
public class LocationTourService extends SimpleAbstractCrudService<LocationTourDto, Long, LocationTourEntity> {

	@Autowired
	private LocationTourRepository dao;

	@Autowired
	private String googleGeocodeWebService;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	protected LocationTourDto mapEntityToDto(LocationTourEntity entity) {
		LocationTourDto dto = new LocationTourDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	protected LocationTourEntity mapDtoToEntity(LocationTourDto dto) {
		LocationTourEntity entity = new LocationTourEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	protected JpaRepository<LocationTourEntity, Long> getDao() {
		return dao;
	}

	public LocationTourDto register(LocationTourRegistrationDto registerDto) throws ElementRegistrationException {
		LocationTourDto locationTourDto = new LocationTourDto();
		BeanUtils.copyProperties(registerDto, locationTourDto);
		return register(locationTourDto);
	}

	public LocationTourDto findInGoogleMaps(String address) {
		try {
			LocationTourDto dto = new LocationTourDto();
			URI googleUri = new URI(googleGeocodeWebService + "&address=" + URLEncoder.encode(address, StandardCharsets.UTF_8.toString()));
			ResponseEntity<String> response = restTemplate.getForEntity(googleUri, String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(response.getBody());
			JsonNode results = root.path("results");
			if (results.isArray()) {
				for (JsonNode item : results) {
					String formattedAddress = item.get("formatted_address").asText();
					String[] split = formattedAddress.split(" - ");
					String string = split[split.length - 1];
					String[] split2 = string.split(", ");
					dto.setCountry(split2[split2.length - 1]);
					dto.setZipCode(split2[split2.length - 2]);
					dto.setState(split2[split2.length - 3]);
					String string2 = split[0];
					if (string2.contains(", ")) {
						dto.setStreet(string2.substring(0, string2.lastIndexOf(", ")));
						dto.setStreetNumber(string2.substring(string2.lastIndexOf(", ") + 2));
					} else {
						dto.setStreet(string2);
					}
					if (split.length == 2) {
						dto.setProvince(string.substring(0, string.indexOf(", ")));
					} else if (split.length == 3) {
						String string3 = split[1];
						String[] split3 = string3.split(", ");
						dto.setProvince(split3[0]);
						dto.setCity(split3[1]);
					}
				}
			}
			return dto;
		} catch (Exception e) {
			throw new ElementNotFoundException("Impossible to find the place.");
		}
	}
}
