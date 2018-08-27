package br.com.passeio_pago.role.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.passeio_pago.common.domain.PaginatedValuesDto;
import br.com.passeio_pago.role.domain.dto.RolePublicDto;
import br.com.passeio_pago.role.domain.dto.RoleRegistrationDto;
import br.com.passeio_pago.role.domain.dto.RoleRegistrationResponseDto;
import br.com.passeio_pago.role.exception.RoleNotFoundException;
import br.com.passeio_pago.role.exception.RoleRegistrationException;
import br.com.passeio_pago.role.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controllers expose the REST Api. They do not implement business logic but
 * call the service layer to perform the required operations and return JSON
 * responses.
 */
@Api(tags = "roles")
@RestController
@RequestMapping(name = "RoleController", path = { "/roles" })
public class RoleController {

	private RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@ApiOperation(value = "Registers a new role, like \"teacher\", \"parent\" or \"both\" for both roles.", tags = "roles")
	@PostMapping(path = "/register")
	public Resource<RoleRegistrationResponseDto> registerRole(@RequestBody @Valid RoleRegistrationDto roleRegistrationDto) throws RoleRegistrationException {
		RoleRegistrationResponseDto registerRole = roleService.registerRole(roleRegistrationDto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).getRoleById(registerRole.getRole().getId()));
		return new Resource<RoleRegistrationResponseDto>(registerRole, linkTo.withRel("self"));
	}

	@ApiOperation(value = "Find roles by criteria", tags = "roles")
	@GetMapping(path = "/search")
	public PaginatedValuesDto<RolePublicDto> findRolesByCriteria(@RequestParam(value = "name", required=true) String name, @RequestParam(value = "pageSize", required=true) Integer pageSize,
			@RequestParam(value = "pageNumber", required=true) Integer pageNumber) {
		return roleService.findRolesByCriteria(name, pageSize, pageNumber);
	}

	@ApiOperation(value = "Get role by id.", tags = "roles")
	@GetMapping(path = "/{roleId}")
	public RolePublicDto getRoleById(@PathVariable("roleId") Long roleId) throws RoleNotFoundException {
		return roleService.getRoleById(roleId);
	}
	
	@ApiOperation(value = "Delete role by id.", tags = "roles")
	@DeleteMapping(path = "/{roleId}")
	public ResponseEntity<Object> deleteRoleById(@PathVariable("roleId") Long roleId) throws RoleNotFoundException {
		roleService.deleteRoleById(roleId);
		return ResponseEntity.ok().build();
	}
}
