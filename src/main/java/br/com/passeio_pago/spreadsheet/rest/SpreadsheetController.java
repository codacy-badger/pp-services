package br.com.passeio_pago.spreadsheet.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.passeio_pago.spreadsheet.service.SpreadsheetService;
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
	public ResponseEntity<Map<String, List<Map<String, Object>>>> uploadFile(@RequestParam("file") MultipartFile file) {
		return ResponseEntity.ok(spreadsheetService.readSpreadsheet(file));
	}

	@ApiOperation(value = "Upload multiple spreadsheet file to the server host.", tags = "spreadsheets")
	@PostMapping("/uploadMultiples")
	public ResponseEntity<List<Map<String, List<Map<String, Object>>>>> uploadMultiplesFile(@RequestParam("files") MultipartFile[] files) {
		List<Map<String, List<Map<String, Object>>>> list = new ArrayList<Map<String, List<Map<String, Object>>>>();
		for (MultipartFile file : files) {
			Map<String, List<Map<String, Object>>> readSpreadsheet = spreadsheetService.readSpreadsheet(file);
			list.add(readSpreadsheet);
		}
		return ResponseEntity.ok(list);
	}
}
