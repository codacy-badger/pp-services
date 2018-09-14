package br.com.passeio_pago.tour.rest;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.passeio_pago.common.controlle.SimpleCrudCrontroller;
import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.student.domain.dto.CompleteInfoStudent;
import br.com.passeio_pago.student_tour.domain.dto.StudentTourDto;
import br.com.passeio_pago.tour.domain.dto.LinkStudentsToTourRequestDto;
import br.com.passeio_pago.tour.domain.dto.TourDto;
import br.com.passeio_pago.tour.domain.dto.TourRegistrationDto;
import br.com.passeio_pago.tour.service.TourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "tours")
@RestController
@RequestMapping(name = "TourController", path = { "/tours" })
public class TourController implements SimpleCrudCrontroller<TourDto, Long, TourRegistrationDto> {

	@Autowired
	private TourService tourService;

	@GetMapping("/all")
	@ApiOperation(value = "get all tours", tags = "tours")
	@Override
	public List<Resource<TourDto>> getAll() {
		return tourService.getAll().stream().map(tour -> {
			Link link = linkTo(methodOn(getClass()).findByID(tour.getId())).withSelfRel();
			return new Resource<TourDto>(tour, link);
		}).collect(Collectors.toList());
	}

	@PostMapping("/register")
	@ApiOperation(value = "Registers a new tour.", tags = "tours")
	@Override
	public Resource<TourDto> register(@RequestBody @Valid TourRegistrationDto registerDto) throws ElementRegistrationException {
		TourDto dto = tourService.register(registerDto);
		Link link = linkTo(methodOn(getClass()).findByID(dto.getId())).withSelfRel();
		return new Resource<TourDto>(dto, link);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete tour by id.", tags = "tours")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) throws BadRequestException, ElementNotFoundException {
		tourService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get tour by id.", tags = "tours")
	@Override
	public TourDto findByID(@PathVariable(name = "id") Long id) throws BadRequestException, ElementNotFoundException {
		return tourService.findByID(id);
	}

	@PostMapping("/linkStudents/{tourId}")
	@ApiOperation(value = "Link a set of students to the specified tour.", tags = "tours")
	public List<StudentTourDto> linkStudentsToTour(@PathVariable(name = "tourId") Long tourId, @RequestBody LinkStudentsToTourRequestDto[] linkStudentsToTourRequestDto)
			throws BadRequestException, ElementNotFoundException {
		return tourService.linkStudentsToTour(tourId, linkStudentsToTourRequestDto);
	}

	@GetMapping("/{tourId}/allStudents")
	@ApiOperation(value = "Get all students enrolled in this tour.", tags = "tours")
	public List<CompleteInfoStudent> getAllStudentsByTourId(@PathVariable(name = "tourId") Long tourId) throws BadRequestException, ElementNotFoundException {
		return tourService.getAllStudentsByTourId(tourId);
	}

	@GetMapping("/{tourId}/{schoolId}/{studentId}")
	@ApiOperation(value = "Get a specific student enrolled in this tour.", tags = "tours")
	public StudentTourDto getStudentsInThisTour(@PathVariable(name = "tourId") Long tourId, @PathVariable(name = "schoolId") String schoolId, @PathVariable(name = "studentId") String studentId)
			throws BadRequestException, ElementNotFoundException {
		return tourService.getSpecificStudentsInThisTour(tourId, schoolId, studentId);
	}

	@PutMapping("/{tourId}/payment/{studentId}")
	@ApiOperation(value = "Tours payment.", tags = "tours")
	public StudentTourDto payTour(@PathVariable(name = "tourId") Long tourId, @PathVariable(name = "studentId") String studentId)
			throws BadRequestException, ElementNotFoundException {
		return tourService.payTour(tourId, studentId);
	}
	
}
