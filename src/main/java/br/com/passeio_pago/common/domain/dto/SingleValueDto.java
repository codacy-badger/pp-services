package br.com.passeio_pago.common.domain.dto;

public class SingleValueDto<T> {
	private T value;

	public SingleValueDto() {
		// Intentionally empty.
	}

	public SingleValueDto(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}
