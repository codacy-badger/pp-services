package br.com.passeio_pago.file_handler.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.passeio_pago.file_handler.payload.UploadFileResponse;
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
	public ResponseEntity<UploadFileResponse> uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = spreadsheetService.readSpreadsheet(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/filesHandler/downloadFile/").path(fileName).toUriString();
		UploadFileResponse response = new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
		return ResponseEntity.ok(response);
	}

	// @PostMapping("/uploadMultipleFiles")
	// @ApiOperation(value = "Upload multiples files to the server host.", tags =
	// "filesHandler")
	// public ResponseEntity<List<UploadFileResponse>>
	// uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
	// List<UploadFileResponse> response = Arrays.asList(files).stream().map(file ->
	// uploadFile(file).getBody()).collect(Collectors.toList());
	// return ResponseEntity.ok(response);
	// }

	// @GetMapping("/downloadFile/{fileName:.+}")
	// @ApiOperation(value = "Upload a file to the server host.", tags =
	// "filesHandler")
	// public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,
	// HttpServletRequest request) {
	// // Load file as Resource
	// Resource resource = spreadsheetService.loadFileAsResource(fileName);
	//
	// // Try to determine file's content type
	// String contentType = null;
	// try {
	// contentType =
	// request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	// } catch (IOException ex) {
	// logger.info("Could not determine file type.");
	// }
	//
	// // Fallback to the default content type if type could not be determined
	// if (contentType == null) {
	// contentType = "application/octet-stream";
	// }
	//
	// return
	// ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION,
	// "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
	// }

}
