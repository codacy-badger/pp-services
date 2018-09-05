package br.com.passeio_pago.file_handler.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.passeio_pago.file_handler.service.SpreadsheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "spreadsheets")
@RestController
@RequestMapping(name = "SpreadsheetController", path = { "/spreadsheets" })
public class SpreadsheetController {

	@Autowired
	private SpreadsheetService spreadsheetService;

	@ApiOperation(value = "Upload a spreadsheet file to the server host.", tags = "spreadsheets")
	@PostMapping("/upload")
	public ResponseEntity<List<Map<String,Object>>> uploadFile(@RequestParam("file") MultipartFile file) {
		List<Map<String,Object>> readSpreadsheet = spreadsheetService.readSpreadsheet(file);
		return ResponseEntity.ok(readSpreadsheet);
	}

}
