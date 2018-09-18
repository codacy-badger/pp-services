package br.com.passeio_pago.tour.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import br.com.passeio_pago.common.controlle.SimpleCrudCrontroller;
import br.com.passeio_pago.common.dto.PaginatedValuesDto;
import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.util.MorePreconditions;
import br.com.passeio_pago.student.domain.dto.CompleteInfoStudent;
import br.com.passeio_pago.student_tour.domain.dto.StudentTourDto;
import br.com.passeio_pago.tour.domain.dto.LinkStudentsToTourRequestDto;
import br.com.passeio_pago.tour.domain.dto.TourDto;
import br.com.passeio_pago.tour.domain.dto.TourRegistrationDto;
import br.com.passeio_pago.tour.service.TourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;;

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
	public PaginatedValuesDto<CompleteInfoStudent> getAllStudentsByTourId(@PathVariable(name = "tourId") Long tourId,
			@ApiParam(required = true, example = "0", defaultValue = "0", allowableValues = "range[0, infinity]", allowEmptyValue = false, allowMultiple = false, value = "Zero based value to specify a page number. Must be equals or greater than 0.") @Min(0) @RequestParam(defaultValue = "0") int pageNumber,
			@ApiParam(required = true, example = "10", defaultValue = "10", allowableValues = "range[1, infinity]", allowEmptyValue = false, allowMultiple = false, value = "The size of each page. Must be greater than 1.") @Min(1) @RequestParam(defaultValue = "10") int pageSize) throws BadRequestException, ElementNotFoundException {
		MorePreconditions.checkPagination(pageSize, pageNumber);
		List<CompleteInfoStudent> list = tourService.getAllStudentsByTourId(tourId);
		list.sort(new Comparator<CompleteInfoStudent>() {
			@Override
			public int compare(CompleteInfoStudent o1, CompleteInfoStudent o2) {
				String o1FullName = o1.getFirstName()+o1.getLastName();
				String o2FullName = o2.getFirstName()+o2.getLastName();
				return o1FullName.compareToIgnoreCase(o2FullName);
			}
		});
		List<List<CompleteInfoStudent>> partition = Lists.partition(list, pageSize);
		PaginatedValuesDto<CompleteInfoStudent> result = null;
		int maxPage = partition.size() - 1;
		if (maxPage < pageNumber) {
			result = new PaginatedValuesDto<CompleteInfoStudent>(new ArrayList<CompleteInfoStudent>(0), pageNumber, 0, false, maxPage);
		} else {
			List<CompleteInfoStudent> list2 = partition.get(pageNumber);
			result = new PaginatedValuesDto<CompleteInfoStudent>(list2, pageNumber, list2.size(), pageNumber < maxPage, maxPage);
		}
		return result;
	}

	@GetMapping("/{tourId}/{schoolId}/{studentId}")
	@ApiOperation(value = "Get a specific student enrolled in this tour.", tags = "tours")
	public StudentTourDto getStudentsInThisTour(@PathVariable(name = "tourId") Long tourId, @PathVariable(name = "schoolId") String schoolId, @PathVariable(name = "studentId") String studentId)
			throws BadRequestException, ElementNotFoundException {
		return tourService.getSpecificStudentsInThisTour(tourId, schoolId, studentId);
	}

	@PutMapping("/{tourId}/payment/{studentId}")
	@ApiOperation(value = "Tours payment.", tags = "tours")
	public StudentTourDto payTour(@PathVariable(name = "tourId") Long tourId, @PathVariable(name = "studentId") String studentId) throws BadRequestException, ElementNotFoundException {
		return tourService.payTour(tourId, studentId);
	}

}
