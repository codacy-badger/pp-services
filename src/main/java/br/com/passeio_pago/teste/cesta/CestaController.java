package br.com.passeio_pago.teste.cesta;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.passeio_pago.common.controlle.SimpleCrudCrontroller;

@RestController
@RequestMapping(path = { "/cestas" })
public class CestaController implements SimpleCrudCrontroller<CestaDto, Long, CestaRegisterDto> {

	@Autowired
	private CestaService cestaService;

	@GetMapping("/")
	@Override
	public  Resources<CestaDto> getAll() {
		List<CestaDto> all = cestaService.getAll();
		List<Link> links = cestaService.getAll().stream().map(cesta -> {
			ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).findByID(cesta.getId()));
			return linkTo.withSelfRel();
		}).collect(Collectors.toList());
		return new Resources<CestaDto>(all, links);
	}

	@PostMapping("/register")
	@Override
	public Resource<CestaDto> register(@RequestBody CestaRegisterDto dto) {
		CestaDto cestaPublicDto = cestaService.register(dto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).findByID(cestaPublicDto.getId()));
		return new Resource<CestaDto>(cestaPublicDto, linkTo.withRel("self"));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
		cestaService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	@Override
	public CestaDto findByID(@PathVariable(name = "id") Long id) {
		return cestaService.findByID(id);
	}

}
