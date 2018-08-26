package br.com.passeio_pago;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	@Autowired
	private TesteRepository repository;

	@GetMapping(path = {"/teste"})
	public String metodo() {

		Team team = new Team();
		team.setName("São Paulo");
		repository.save(team);

		return "ok";
	}
	
	@GetMapping(path = {"/buscar"})
	public ResponseEntity<List<Team>> buscar() {

		List<Team> findAll = repository.findAll();

		return new ResponseEntity<List<Team>>(findAll, HttpStatus.OK);
	}

}
