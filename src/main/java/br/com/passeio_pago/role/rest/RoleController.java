package br.com.passeio_pago.role.rest;

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
import br.com.passeio_pago.role.domain.dto.RoleDto;
import br.com.passeio_pago.role.domain.dto.RoleRegistrationDto;
import br.com.passeio_pago.role.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "roles")
@RestController
@RequestMapping(name = "RoleController", path = { "/roles" })
public class RoleController implements SimpleCrudCrontroller<RoleDto, Long, RoleRegistrationDto> {

	@Autowired
	private RoleService roleService;

	@GetMapping("/all")
	@ApiOperation(value = "get all roles", tags = "roles")
	@Override
	public Resources<RoleDto> getAll() {
		List<RoleDto> all = roleService.getAll();
		List<Link> links = all.stream().map(role -> linkTo(methodOn(getClass()).findByID(role.getId())).withSelfRel()).collect(Collectors.toList());
		return new Resources<RoleDto>(all, links);
	}

	@PostMapping("/register")
	@ApiOperation(value = "Registers a new role, like \"teacher\", \"parent\" or \"both\" for both roles.", tags = "roles")
	@Override
	public Resource<RoleDto> register(@RequestBody @Valid RoleRegistrationDto registerDto) throws ElementRegistrationException {
		RoleDto dto = roleService.register(registerDto);
		Link link = linkTo(methodOn(getClass()).findByID(dto.getId())).withSelfRel();
		return new Resource<RoleDto>(dto, link);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete role by id.", tags = "roles")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) throws BadRequestException, ElementNotFoundException {
		roleService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get role by id.", tags = "roles")
	@Override
	public RoleDto findByID(@PathVariable(name = "id") Long id) throws BadRequestException, ElementNotFoundException {
		return roleService.findByID(id);
	}

}
