package br.com.passeio_pago.qrcode.service;

import java.net.URI;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.passeio_pago.common.exception.BadRequestException;
import br.com.passeio_pago.qrcode.domain.dto.QrCodeCreateDto;
import br.com.passeio_pago.qrcode.domain.dto.QrCodeCreateDto.QrCodeSize;

@Service
public class QrCodeService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private String goQrCodeWebService;

	public String createQrCode(QrCodeCreateDto request) {
		try {
			URI uri;
			uri = new URI(goQrCodeWebService + buildUri(request.getData(), request.getFormat(), request.getMargin(), request.getqZone(), request.getSize()));
			byte[] qrcode = restTemplate.getForObject(uri, byte[].class);
			String encodedfile = new String(Base64.encodeBase64(qrcode), "UTF-8");
			return encodedfile;
		} catch (Exception e) {
			throw new BadRequestException("Error in create QR code.");
		}
	}

	private String buildUri(String data, String format, Integer margin, Integer getqZone, QrCodeSize size) {
		String uri = String.format("?data=%s&format=%s&margin=%d&qZone=%d&size=%sx%s", "https://passeio-pago.herokuapp.com/buscar/" + data, format, margin, getqZone, size.getWidth(),
				size.getLength());
		return uri;
	}
//
//	private static String encodeFileToBase64Binary(File file) throws Exception {
//		String encodedfile = null;
//		FileInputStream fileInputStreamReader = new FileInputStream(file);
//		byte[] bytes = new byte[(int) file.length()];
//		fileInputStreamReader.read(bytes);
//		encodedfile = Base64.encodeBase64(bytes).toString();
//		fileInputStreamReader.close();
//		return encodedfile;
//	}
}
