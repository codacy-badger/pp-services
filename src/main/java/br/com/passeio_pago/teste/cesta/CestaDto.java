package br.com.passeio_pago.teste.cesta;

import java.io.Serializable;

public class CestaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3199944571682296283L;

	private Long id;
	private String cor;

	public CestaDto(Long id, String cor) {
		super();
		setId(id);
		setCor(cor);
	}

	public CestaDto(String cor) {
		this(null, cor);
	}

	public CestaDto() {
		this(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
