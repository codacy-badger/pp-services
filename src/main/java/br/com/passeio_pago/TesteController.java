package br.com.passeio_pago;

import org.springframework.beans.factory.annotation.Autowired;
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

}
