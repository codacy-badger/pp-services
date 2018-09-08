package br.com.passeio_pago.location_tour.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.passeio_pago.common.controlle.SimpleCrudCrontroller;
import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourDto;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourRegistrationDto;
import br.com.passeio_pago.location_tour.service.LocationTourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "locationsTour")
@RestController
@RequestMapping(name = "LocationTourController", path = { "/locationsTour" })
public class LocationTourController implements SimpleCrudCrontroller<LocationTourDto, Long, LocationTourRegistrationDto> {

	@Autowired
	private LocationTourService locationTourService;

	@GetMapping("/all")
	@ApiOperation(value = "get all locations tour", tags = "locationsTour")
	@Override
	public List<Resource<LocationTourDto>> getAll() {
		return locationTourService.getAll().stream().map(location -> {
			Link link = linkTo(methodOn(getClass()).findByID(location.getId())).withSelfRel();
			return new Resource<LocationTourDto>(location, link);
		}).collect(Collectors.toList());
	}

	@PostMapping("/register")
	@ApiOperation(value = "Registers a new location tour.", tags = "locationsTour")
	@Override
	public Resource<LocationTourDto> register(@RequestBody @Valid LocationTourRegistrationDto registerDto) throws ElementRegistrationException {
		LocationTourDto dto = locationTourService.register(registerDto);
		Link link = linkTo(methodOn(getClass()).findByID(dto.getId())).withSelfRel();
		return new Resource<LocationTourDto>(dto, link);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a location tour by id.", tags = "locationsTour")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) throws BadRequestException, ElementNotFoundException {
		locationTourService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get location tour by id.", tags = "locationsTour")
	@Override
	public LocationTourDto findByID(@PathVariable(name = "id") Long id) throws BadRequestException, ElementNotFoundException {
		return locationTourService.findByID(id);
	}

	@GetMapping("/googleMaps")
	@ApiOperation(value = "Get location tour in Google Maps. Example: Museu do Amanhã, Hopi Hari, Museu do Ipiranga, any String or Zip Code.", tags = "locationsTour")
	public LocationTourDto findInGoogleMaps(
			@ApiParam(required = true, example = "Museu do Ipiranga", value = "The place to be looked for.") @RequestParam(name = "address", required = true) String address)
			throws ElementNotFoundException {
		return locationTourService.findInGoogleMaps(address);
	}

}
