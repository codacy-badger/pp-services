package br.com.passeio_pago.common.domain.dto;

import java.util.Collection;

public class ValuesListDto<T> {
	private Collection<T> values;

	public ValuesListDto() {
		// Intentionally empty.
	}

	public ValuesListDto(Collection<T> values) {
		this.values = values;
	}

	public Collection<T> getValues() {
		return values;
	}
}
