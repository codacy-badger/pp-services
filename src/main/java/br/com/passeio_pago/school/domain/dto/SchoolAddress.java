package br.com.passeio_pago.school.domain.dto;

import java.io.Serializable;

public class SchoolAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5121453266890141548L;
	private String bairro;
	private String cep;
	private String descricao;
	private String municipio;
	private String uf;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
