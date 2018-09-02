package br.com.passeio_pago.account.rest;

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

import br.com.passeio_pago.account.domain.dto.AccountDto;
import br.com.passeio_pago.account.domain.dto.AccountRegistrationDto;
import br.com.passeio_pago.account.service.AccountService;
import br.com.passeio_pago.common.controlle.SimpleCrudCrontroller;
import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.common.exception.ElementNotFoundException;
import br.com.passeio_pago.common.exception.ElementRegistrationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "accounts")
@RestController
@RequestMapping(name = "AccountController", path = { "/accounts" })
public class AccountController implements SimpleCrudCrontroller<AccountDto, Long, AccountRegistrationDto> {

	@Autowired
	private AccountService accountService;

	@GetMapping("/all")
	@ApiOperation(value = "get all accounts", tags = "accounts")
	@Override
	public Resources<AccountDto> getAll() {
		List<AccountDto> all = accountService.getAll();
		List<Link> links = all.stream().map(account -> linkTo(methodOn(getClass()).findByID(account.getId())).withSelfRel()).collect(Collectors.toList());
		return new Resources<AccountDto>(all, links);
	}

	@PostMapping("/register")
	@ApiOperation(value = "Registers a new account, like \"teacher\", \"parent\" or \"both\" for both accounts.", tags = "accounts")
	@Override
	public Resource<AccountDto> register(@RequestBody @Valid AccountRegistrationDto registerDto) throws ElementRegistrationException {
		AccountDto dto = accountService.register(registerDto);
		Link link = linkTo(methodOn(getClass()).findByID(dto.getId())).withSelfRel();
		return new Resource<AccountDto>(dto, link);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete account by id.", tags = "accounts")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) throws BadRequestException, ElementNotFoundException {
		accountService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get account by id.", tags = "accounts")
	@Override
	public AccountDto findByID(@PathVariable(name = "id") Long id) throws BadRequestException, ElementNotFoundException {
		return accountService.findByID(id);
	}

}