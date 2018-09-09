package br.com.passeio_pago.school.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.passeio_pago.school.domain.dto.School;
import br.com.passeio_pago.school.service.SchoolService;
import br.com.passeio_pago.tour.domain.dto.TourDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "schools")
@RestController
@RequestMapping(name = "SchoolController", path = "/schools")
public class SchoolController {

	@Autowired
	private SchoolService service;

	@ApiOperation(value = "Search of schools. Return the top 50 that most approach the criterias. Note that no parameter is required.", tags = "schools")
	@GetMapping("/")
	public ResponseEntity<School[]> getSchools(@ApiParam(required = false, example = "maria theodora", value = "The name of the school.") @RequestParam(required = false, name = "nome") String nome,
			@ApiParam(required = false, example = "Pública", value = "Type of school.", allowableValues = "Pública,Privada") @RequestParam(required = false, name = "rede") String rede,
			@ApiParam(required = false, example = "Barueri", value = "The city of the school.") @RequestParam(required = false, name = "municipio") String municipio,
			@ApiParam(required = false, example = "SP", value = "The state of the school.", allowableValues = "AC,AL,AP,AM,BA,CE,DF,ES,GO,MA,MT,MS,MG,PA,PB,PR,PE,PI,RJ,RN,RS,RO,RR,SC,SP,SE,TO") @RequestParam(required = false, name = "uf") String uf,
			@ApiParam(required = false, example = "Municipal", allowableValues = "Estadual,Municipal,Federal,Privada") @RequestParam(required = false, name = "esferaAdministrativa") String esferaAdministrativa) {
		School[] schools = service.getSchoolsByAddress(nome, rede, municipio, uf, esferaAdministrativa);
		return ResponseEntity.ok(schools);
	}

	@ApiOperation(value = "Search a schools by id.", tags = "schools")
	@GetMapping("/{schoolId}")
	public ResponseEntity<School> getSchools(@PathVariable(name = "schoolId") Long schoolId) {
		School schools = service.getSchoolsById(schoolId);
		return ResponseEntity.ok(schools);
	}

	@ApiOperation(value = "Get all tours in a specific school.", tags = "schools")
	@GetMapping("/{schoolId}/allTours")
	public ResponseEntity<List<TourDto>> getAllToursBySchoolId(@PathVariable(name = "schoolId") Long schoolId) {
		return ResponseEntity.ok(service.getAllToursBySchoolId(schoolId));
	}
}
