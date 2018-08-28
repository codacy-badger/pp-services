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
import br.com.passeio_pago.account.exception.AccountNotFoundException;
import br.com.passeio_pago.account.exception.AccountRegistrationException;
import br.com.passeio_pago.account.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controllers expose the REST Api. They do not implement business logic but
 * call the service layer to perform the required operations and return JSON
 * responses.
 */
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
	public Resource<AccountRegistrationResponseDto> registerAccount(@RequestBody @Valid AccountRegistrationDto accountRegistrationDto) throws AccountRegistrationException {
		AccountRegistrationResponseDto registerAccount = accountService.register(accountRegistrationDto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).getAccountById(registerAccount.getAccount().getId()));
		return new Resource<AccountRegistrationResponseDto>(registerAccount, linkTo.withRel("self"));
	}

	@ApiOperation(value = "Find accounts by criteria", tags = "accounts")
	@GetMapping(path = "/all")
	public Page<AccountPublicDto> findAllAccounts(@RequestParam(value = "pageSize", required = true) Integer pageSize, @RequestParam(value = "pageNumber", required = true) Integer pageNumber) {
		return accountService.findAll(pageNumber, pageSize);
	}

	@ApiOperation(value = "Get account by id.", tags = "accounts")
	@GetMapping(path = "/{accountId}")
	public AccountPublicDto getAccountById(@PathVariable("accountId") Long accountId) throws AccountNotFoundException {
		return accountService.findById(accountId);
	}

	@ApiOperation(value = "Delete account by id.", tags = "accounts")
	@DeleteMapping(path = "/{accountId}")
	public ResponseEntity<Object> deleteAccountById(@PathVariable("accountId") Long accountId) throws AccountNotFoundException {
		accountService.deleteById(accountId);
		return ResponseEntity.ok().build();
	}
}
