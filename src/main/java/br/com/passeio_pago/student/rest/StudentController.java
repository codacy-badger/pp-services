package br.com.passeio_pago.student.rest;

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
import br.com.passeio_pago.student.domain.dto.StudentPublicDto;
import br.com.passeio_pago.student.domain.dto.StudentRegistrationDto;
import br.com.passeio_pago.student.domain.dto.StudentRegistrationResponseDto;
import br.com.passeio_pago.student.domain.entity.StudentEntityPK;
import br.com.passeio_pago.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "students")
@RestController
@RequestMapping(name = "StudentController", path = { "/students" })
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@ApiOperation(value = "Registers a new student.", tags = "students")
	@PostMapping(path = "/register")
	public Resource<StudentRegistrationResponseDto> registerStudent(@RequestBody @Valid StudentRegistrationDto studentRegistrationDto) throws ElementRegistrationException {
		StudentRegistrationResponseDto registerStudent = studentService.register(studentRegistrationDto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).getStudentById(registerStudent.getStudent().getRegistrationId(), registerStudent.getStudent().getSchoolId()));
		return new Resource<StudentRegistrationResponseDto>(registerStudent, linkTo.withRel("self"));
	}

	@ApiOperation(value = "Get all students", tags = "students")
	@GetMapping(path = "/all")
	public Page<StudentPublicDto> findAllStudents(
			@ApiParam(name = "pageSize", defaultValue = "10", required = false, allowableValues = "range[1, infinity]", allowEmptyValue = false, allowMultiple = false, example = "10", value = "Size of the page.") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(name = "pageNumber", defaultValue = "0", required = false, allowableValues = "range[0, infinity]", allowEmptyValue = false, allowMultiple = false, example = "0", value = "Zero-based page index.") @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber)
			throws BadRequestException {
		return studentService.findAll(pageNumber, pageSize);
	}

	@ApiOperation(value = "Get student by id.", tags = "students")
	@GetMapping(path = "/{schoolId}/{registrationId}")
	public StudentPublicDto getStudentById(@PathVariable("registrationId") String registrationId, @PathVariable("schoolId") String schoolId) throws ElementNotFoundException {
		return studentService.findById(new StudentEntityPK(registrationId, schoolId));
	}

	@ApiOperation(value = "Delete student by id.", tags = "students")
	@DeleteMapping(path = "/{schoolId}/{registrationId}")
	public ResponseEntity<Object> deleteStudentById(@PathVariable("registrationId") String registrationId, @PathVariable("schoolId") String schoolId) throws ElementNotFoundException {
		studentService.deleteById(new StudentEntityPK(registrationId, schoolId));
		return ResponseEntity.ok().build();
	}
}
