package br.com.passeio_pago.teste.fruta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.passeio_pago.teste.cesta.CestaEntity;

@Entity
@Table(name = "fruta")
public class FrutaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruta_sequence")
	@SequenceGenerator(name = "fruta_sequence", sequenceName = "fruta_sequence")
	private Long id;

	@Column(name = "nome", nullable = false, unique = true)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cesta_id", nullable = false)
	private CestaEntity cesta;

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

	public CestaEntity getCesta() {
		return cesta;
	}

	public void setCesta(CestaEntity cesta) {
		this.cesta = cesta;
	}

}
