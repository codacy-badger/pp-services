package br.com.passeio_pago.qrcode.domain.dto;

import java.io.Serializable;

public class QrCode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5181147822436030849L;
	private String byteArray;

	/**
	 * @return the byteArray
	 */
	public String getByteArray() {
		return byteArray;
	}

	/**
	 * @param byteArray the byteArray to set
	 */
	public void setByteArray(String byteArray) {
		this.byteArray = byteArray;
	}
	
}
