package br.com.passeio_pago.location_tour.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.util.MorePreconditions;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourPublicDto;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourRegistrationDto;
import br.com.passeio_pago.location_tour.domain.dto.LocationTourRegistrationResponseDto;
import br.com.passeio_pago.location_tour.service.LocationTourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "locationsTour")
@RestController
@RequestMapping(name = "LocationTourController", path = { "/locationsTour" })
public class LocationTourController {

	@Autowired
	private LocationTourService locationTourService;

	@ApiOperation(value = "Registers a new location tour.", tags = "locationsTour")
	@PostMapping(path = "/register")
	public Resource<LocationTourRegistrationResponseDto> registerLocationTour(@RequestBody @Valid LocationTourRegistrationDto locationTourRegistrationDto) throws ElementRegistrationException {
		LocationTourRegistrationResponseDto registerLocationTour = locationTourService.register(locationTourRegistrationDto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).getLocationTourById(registerLocationTour.getLocationTour().getId()));
		return new Resource<LocationTourRegistrationResponseDto>(registerLocationTour, linkTo.withRel("self"));
	}

	@ApiOperation(value = "Get all locations tour.", tags = "locationsTour")
	@GetMapping(path = "/all")
	public Page<LocationTourPublicDto> findAllLocationsTour(
			@ApiParam(name = "pageSize", defaultValue = "10", required = false, allowableValues = "range[1, infinity]", allowEmptyValue = false, allowMultiple = false, example = "10", value = "Size of the page.") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "pageNumber", defaultValue = "0", required = false, allowableValues = "range[0, infinity]", allowEmptyValue = false, allowMultiple = false, example = "0", value = "Zero-based page index.") @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber)
			throws BadRequestException {
		MorePreconditions.checkPagination(pageSize, pageNumber);
		return locationTourService.findAll(pageNumber, pageSize);
	}

	@ApiOperation(value = "Get location tour by id.", tags = "locationsTour")
	@GetMapping(path = "/{locationTourId}")
	public LocationTourPublicDto getLocationTourById(@PathVariable("locationTourId") Long locationTourId) throws ElementNotFoundException {
		return locationTourService.findById(locationTourId);
	}

	@ApiOperation(value = "Delete location tour by id.", tags = "locationsTour")
	@DeleteMapping(path = "/{locationsTourId}")
	public ResponseEntity<Object> deleteLocationTourById(@PathVariable("locationsTourId") Long locationTourId) throws ElementNotFoundException {
		locationTourService.deleteById(locationTourId);
		return ResponseEntity.ok().build();
	}
}
