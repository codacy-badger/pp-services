package br.com.passeio_pago.teste.cesta;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.passeio_pago.teste.fruta.FrutaEntity;

@Entity
@Table(name = "cesta")
public class CestaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cesta_sequence")
	@SequenceGenerator(name = "cesta_sequence", sequenceName = "cesta_sequence")
	private Long id;

	@Column(name = "cor", nullable = false, unique = false)
	private String cor;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cesta", fetch = FetchType.EAGER)
	private Set<FrutaEntity> frutas;

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

	public Set<FrutaEntity> getFrutas() {
		return frutas;
	}

	public void setFrutas(Set<FrutaEntity> frutas) {
		this.frutas = frutas;
	}

}
