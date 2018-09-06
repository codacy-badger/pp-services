package br.com.passeio_pago.location_tour.service;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

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

	private static List<String> googleAddressComponentTypes = Arrays.asList("street_number", "route", "sublocality_level_1", "administrative_area_level_2", "administrative_area_level_1", "country",
			"postal_code");

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
					JsonNode addressComponents = item.get("address_components");
					if (addressComponents.isArray()) {
						for (JsonNode component : addressComponents) {
							String longName = component.get("long_name").asText();
							String shortName = component.get("short_name").asText();
							JsonNode types = component.get("types");
							if (types.isArray()) {
								for (JsonNode type : types) {
									String typeValue = type.asText();
									if (googleAddressComponentTypes.contains(typeValue)) {
										switch (typeValue) {
										case "street_number":
											dto.setStreetNumber(longName);
											break;
										case "route":
											dto.setStreet(longName);
											break;
										case "sublocality_level_1":
											dto.setProvince(longName);
											break;
										case "administrative_area_level_2":
											dto.setCity(longName);
											break;
										case "administrative_area_level_1":
											dto.setState(shortName);
											dto.setStateFullName(longName);
											break;
										case "country":
											dto.setCountry(longName);
											break;
										case "postal_code":
											dto.setZipCode(longName);
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			return dto;
		} catch (Exception e) {
			throw new ElementNotFoundException("Impossible to find the place.");
		}
	}
}
