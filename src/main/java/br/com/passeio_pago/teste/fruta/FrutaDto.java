package br.com.passeio_pago.teste.fruta;

import java.io.Serializable;

public class FrutaDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4707884701530439502L;

	private Long id;
	private String nome;
	private Long cestaId;

	public FrutaDto() {
		this(null, null);
	}

	public FrutaDto(Long id, String nome, Long cestaId) {
		super();
		setId(id);
		setNome(nome);
		setCestaId(cestaId);
	}

	public FrutaDto(String nome, Long cestaId) {
		this(null, nome, cestaId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCestaId() {
		return cestaId;
	}

	public void setCestaId(Long cestaId) {
		this.cestaId = cestaId;
	}

}
