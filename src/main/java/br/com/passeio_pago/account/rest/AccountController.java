package br.com.passeio_pago.account.rest;

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

import br.com.passeio_pago.account.domain.dto.AccountPublicDto;
import br.com.passeio_pago.account.domain.dto.AccountRegistrationDto;
import br.com.passeio_pago.account.domain.dto.AccountRegistrationResponseDto;
import br.com.passeio_pago.account.service.AccountService;
import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import br.com.passeio_pago.common.util.MorePreconditions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "accounts")
@RestController
@RequestMapping(name = "AccountController", path = { "/accounts" })
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@ApiOperation(value = "Registers a new account.", tags = "accounts")
	@PostMapping(path = "/register")
	public Resource<AccountRegistrationResponseDto> registerAccount(@RequestBody @Valid AccountRegistrationDto accountRegistrationDto) throws ElementRegistrationException {
		AccountRegistrationResponseDto registerAccount = accountService.register(accountRegistrationDto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).getAccountById(registerAccount.getAccount().getId()));
		return new Resource<AccountRegistrationResponseDto>(registerAccount, linkTo.withRel("self"));
	}

	@ApiOperation(value = "Get all accounts.", tags = "accounts")
	@GetMapping(path = "/all")
	public Page<AccountPublicDto> findAllAccounts(@ApiParam(name = "pageSize", allowableValues = "[1, infinity]") @RequestParam(value = "pageSize", required = true) Integer pageSize,
			@ApiParam(name = "pageSize", allowableValues = "[0, infinity]") @RequestParam(value = "pageNumber", required = true) Integer pageNumber) throws BadRequestException {
		MorePreconditions.checkPagination(pageSize, pageNumber);
		return accountService.findAll(pageNumber, pageSize);
	}

	@ApiOperation(value = "Get account by id.", tags = "accounts")
	@GetMapping(path = "/{accountId}")
	public AccountPublicDto getAccountById(@PathVariable("accountId") Long accountId) throws ElementNotFoundException {
		return accountService.findById(accountId);
	}

	@ApiOperation(value = "Delete account by id.", tags = "accounts")
	@DeleteMapping(path = "/{accountId}")
	public ResponseEntity<Object> deleteAccountById(@PathVariable("accountId") Long accountId) throws ElementNotFoundException {
		accountService.deleteById(accountId);
		return ResponseEntity.ok().build();
	}
}
