package br.com.passeio_pago.school.domain.dto;

import java.io.Serializable;

public class SchoolHateoasLinks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8444019524080189773L;
	private String href;
	private String rel;
	private Boolean templated;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public Boolean getTemplated() {
		return templated;
	}

	public void setTemplated(Boolean templated) {
		this.templated = templated;
	}

}
