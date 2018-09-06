package br.com.passeio_pago.school.domain.dto;

import java.io.Serializable;

public class School implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -669202199255161423L;
	private Long codEscola;
	private String cnpj;
	private String nome;
	private String rede;
	private String esferaAdministrativa;
	private String tipoConvenioPoderPublico;
	private String email;
	private String telefone;
	private String urlWebSite;
	private SchoolHateoasLinks[] links;
	private SchoolAddress endereco;
	private String zona;

	// private String categoriaEscolaPrivada;
	// private SchoolInfrastructure infraestrutura;
	// private Long latitude;
	// private Long longitude;
	// private Long qtdAlunos;
	// private Long qtdComputadores;
	// private Long qtdComputadoresPorAluno;
	// private Long qtdFuncionarios;
	// private Long qtdSalasExistentes;
	// private Long qtdSalasUtilizadas;
	// private String seConveniadaSetorPublico;
	// private String seFimLucrativo;
	// private String situacaoFuncionamento;

	public Long getCodEscola() {
		return codEscola;
	}

	public void setCodEscola(Long codEscola) {
		this.codEscola = codEscola;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRede() {
		return rede;
	}

	public void setRede(String rede) {
		this.rede = rede;
	}

	public String getEsferaAdministrativa() {
		return esferaAdministrativa;
	}

	public void setEsferaAdministrativa(String esferaAdministrativa) {
		this.esferaAdministrativa = esferaAdministrativa;
	}

	public String getTipoConvenioPoderPublico() {
		return tipoConvenioPoderPublico;
	}

	public void setTipoConvenioPoderPublico(String tipoConvenioPoderPublico) {
		this.tipoConvenioPoderPublico = tipoConvenioPoderPublico;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUrlWebSite() {
		return urlWebSite;
	}

	public void setUrlWebSite(String urlWebSite) {
		this.urlWebSite = urlWebSite;
	}

	public SchoolHateoasLinks[] getLinks() {
		return links;
	}

	public void setLinks(SchoolHateoasLinks[] links) {
		this.links = links;
	}

	public SchoolAddress getEndereco() {
		return endereco;
	}

	public void setEndereco(SchoolAddress endereco) {
		this.endereco = endereco;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

}
