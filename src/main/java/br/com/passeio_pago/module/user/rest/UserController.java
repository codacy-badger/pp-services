package br.com.passeio_pago.module.user.rest;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.passeio_pago.module.common.domain.PaginatedValuesDto;
import br.com.passeio_pago.module.user.domain.UserPrivate;
import br.com.passeio_pago.module.user.domain.dto.UserPublicDto;
import br.com.passeio_pago.module.user.domain.dto.UserRegistrationDto;
import br.com.passeio_pago.module.user.domain.dto.UserRegistrationResponseDto;
import br.com.passeio_pago.module.user.exception.UserNotFoundException;
import br.com.passeio_pago.module.user.exception.UserRegistrationException;
import br.com.passeio_pago.module.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controllers expose the REST Api. They do not implement business logic but
 * call the service layer to perform the required operations and return JSON
 * responses.
 */
@Api(tags = "users")
@RestController
@RequestMapping(value = "/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "Registers a new user.", tags = "users")
	@PostMapping(path = "/register")
	public UserRegistrationResponseDto<UserPrivate> registerUser(@RequestBody @Valid UserRegistrationDto userRegistrationDto) throws UserRegistrationException, UserNotFoundException {
		logger.info(ToStringBuilder.reflectionToString(userRegistrationDto));
		return userService.registerUser(userRegistrationDto);
	}

	@ApiOperation(value = "Find users by criteria", tags = "users")
	@GetMapping(path = "/search")
	public PaginatedValuesDto<UserPublicDto> findUsersByCriteria(@RequestParam(value = "fullName") String fullName, @RequestParam(value = "pageSize") Integer pageSize,
			@RequestParam(value = "pageNum") Integer pageNum) {
		return userService.findUsersByCriteria(fullName, pageSize, pageNum);
	}

	@ApiOperation(value = "Get user by id", tags = "users")
	@GetMapping(path = "/{userId}")
	public UserPublicDto getUserById(@PathVariable("userId") String userId) throws UserNotFoundException {
		return userService.getUserById(userId);
	}
}
