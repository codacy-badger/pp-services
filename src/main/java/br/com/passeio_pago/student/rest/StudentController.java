package br.com.passeio_pago.student.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.passeio_pago.common.controlle.SimpleCrudCrontroller;
import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.student.domain.dto.StudentDto;
import br.com.passeio_pago.student.domain.dto.StudentRegistrationDto;
import br.com.passeio_pago.student.domain.entity.StudentEntityPK;
import br.com.passeio_pago.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "students")
@RestController
@RequestMapping(name = "StudentController", path = { "/students" })
public class StudentController implements SimpleCrudCrontroller<StudentDto, StudentEntityPK, StudentRegistrationDto> {

	@Autowired
	private StudentService studentService;

	@GetMapping("/all")
	@ApiOperation(value = "get all students", tags = "students")
	@Override
	public Resources<StudentDto> getAll() {
		List<StudentDto> all = studentService.getAll();
		List<Link> links = all.stream().map(student -> linkTo(methodOn(getClass()).findByID(student.getRegistrationId(), student.getSchoolId())).withSelfRel()).collect(Collectors.toList());
		return new Resources<StudentDto>(all, links);
	}

	@PostMapping("/register")
	@ApiOperation(value = "Registers a new student.", tags = "students")
	@Override
	public Resource<StudentDto> register(@RequestBody @Valid StudentRegistrationDto registerDto) throws ElementRegistrationException {
		StudentDto dto = studentService.register(registerDto);
		Link link = linkTo(methodOn(getClass()).findByID(dto.getRegistrationId(), dto.getSchoolId())).withSelfRel();
		return new Resource<StudentDto>(dto, link);
	}

	@Override
	public ResponseEntity<Object> deleteById(StudentEntityPK id) {
		studentService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{schoolId}/{registrationId}")
	@ApiOperation(value = "Delete student by id.", tags = "students")
	public ResponseEntity<Object> deleteById(@PathVariable("registrationId") String registrationId, @PathVariable("schoolId") String schoolId) throws BadRequestException, ElementNotFoundException {
		StudentEntityPK id = new StudentEntityPK();
		id.setRegistrationId(registrationId);
		id.setSchoolId(schoolId);
		return deleteById(id);
	}

	@Override
	public StudentDto findByID(StudentEntityPK id) throws BadRequestException, ElementNotFoundException {
		return studentService.findByID(id);
	}

	@GetMapping("/{schoolId}/{registrationId}")
	@ApiOperation(value = "Get student by id.", tags = "students")
	public StudentDto findByID(@PathVariable("registrationId") String registrationId, @PathVariable("schoolId") String schoolId) throws BadRequestException, ElementNotFoundException {
		StudentEntityPK id = new StudentEntityPK();
		id.setRegistrationId(registrationId);
		id.setSchoolId(schoolId);
		return findByID(id);
	}
}
