package com.dtb.cadastrocontratos.model.converters;

public interface Converter<E, D> {
	public Convert<E, D> toDto(Class<D> dtoClazz);

	public Convert<D, E> toEntity(Class<E> entityClazz);
}
