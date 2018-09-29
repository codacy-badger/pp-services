package br.com.passeio_pago.qrcode.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.passeio_pago.qrcode.domain.dto.QrCode;
import br.com.passeio_pago.qrcode.domain.dto.QrCodeCreateDto;
import br.com.passeio_pago.qrcode.service.QrCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "qrCode")
@RestController
@RequestMapping(name = "QrCodeController", path = { "/qrCode" })
public class QrCodeController {

	@Autowired
	private QrCodeService qrCodeService;

	@PostMapping("/create")
	@ApiOperation(value = "Create a QR code with these contents.", tags = "qrCode")
	public ResponseEntity<QrCode> createQrCode(@RequestBody @Valid QrCodeCreateDto request) {
		String qrcode = qrCodeService.createQrCode(request);
		QrCode qr = new QrCode();
		qr.setByteArray(qrcode);
		return ResponseEntity.ok(qr);
	}

}
