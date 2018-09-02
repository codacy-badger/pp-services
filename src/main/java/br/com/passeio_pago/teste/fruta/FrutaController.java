package br.com.passeio_pago.teste.fruta;

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
@RequestMapping(path = { "/frutas" })
public class FrutaController implements SimpleCrudCrontroller<FrutaDto, Long, FrutaRegisterDto> {

	@Autowired
	private FrutaService frutaService;

	@GetMapping("/")
	@Override
	public Resources<FrutaDto> getAll() {
		List<FrutaDto> all = frutaService.getAll();
		List<Link> links = frutaService.getAll().stream().map(fruta -> {
			ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).findByID(fruta.getId()));
			return linkTo.withSelfRel();
		}).collect(Collectors.toList());
		return new Resources<FrutaDto>(all, links);
	}

	@PostMapping("/register")
	@Override
	public Resource<FrutaDto> register(@RequestBody FrutaRegisterDto dto) {
		FrutaDto frutaPublicDto = frutaService.register(dto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).findByID(frutaPublicDto.getId()));
		return new Resource<FrutaDto>(frutaPublicDto, linkTo.withRel("self"));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
		frutaService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	@Override
	public FrutaDto findByID(@PathVariable(name = "id") Long id) {
		return frutaService.findByID(id);
	}

}
