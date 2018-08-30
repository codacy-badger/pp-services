package br.com.passeio_pago.tour.rest;

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
import br.com.passeio_pago.tour.domain.dto.TourPublicDto;
import br.com.passeio_pago.tour.domain.dto.TourRegistrationDto;
import br.com.passeio_pago.tour.domain.dto.TourRegistrationResponseDto;
import br.com.passeio_pago.tour.service.TourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "tours")
@RestController
@RequestMapping(name = "TourController", path = { "/tours" })
public class TourController {

	private TourService tourService;

	@Autowired
	public TourController(TourService tourService) {
		this.tourService = tourService;
	}

	@ApiOperation(value = "Registers a new tour.", tags = "tours")
	@PostMapping(path = "/register")
	public Resource<TourRegistrationResponseDto> registerTour(@RequestBody @Valid TourRegistrationDto tourRegistrationDto) throws ElementRegistrationException {
		TourRegistrationResponseDto registerTour = tourService.register(tourRegistrationDto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).getTourById(registerTour.getTour().getId()));
		return new Resource<TourRegistrationResponseDto>(registerTour, linkTo.withRel("self"));
	}

	@ApiOperation(value = "Get all tours.", tags = "tours")
	@GetMapping(path = "/all")
	public Page<TourPublicDto> findAllTours(
			@ApiParam(name = "pageSize", defaultValue = "10", required = false, allowableValues = "range[1, infinity]", allowEmptyValue = false, allowMultiple = false, example = "10", value = "Size of the page.") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "pageNumber", defaultValue = "0", required = false, allowableValues = "range[0, infinity]", allowEmptyValue = false, allowMultiple = false, example = "0", value = "Zero-based page index.") @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber)
			throws BadRequestException {
		MorePreconditions.checkPagination(pageSize, pageNumber);
		return tourService.findAll(pageNumber, pageSize);
	}

	@ApiOperation(value = "Get tour by id.", tags = "tours")
	@GetMapping(path = "/{tourId}")
	public TourPublicDto getTourById(@PathVariable("tourId") Long tourId) throws ElementNotFoundException {
		return tourService.findById(tourId);
	}

	@ApiOperation(value = "Delete tour by id.", tags = "tours")
	@DeleteMapping(path = "/{tourId}")
	public ResponseEntity<Object> deleteTourById(@PathVariable("tourId") Long tourId) throws ElementNotFoundException {
		tourService.deleteById(tourId);
		return ResponseEntity.ok().build();
	}
}
