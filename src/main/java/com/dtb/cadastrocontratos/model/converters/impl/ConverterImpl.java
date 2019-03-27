package com.dtb.cadastrocontratos.model.converters.impl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.dtb.cadastrocontratos.model.converters.Convert;
import com.dtb.cadastrocontratos.model.converters.Converter;

@Component
public class ConverterImpl<E, D> implements Converter<E, D>{
	
	@Override
	public Convert<E, D> toDto(Class<D> dtoClazz) {
		return entity -> map().map(entity, dtoClazz);
	}

	@Override
	public Convert<D, E> toEntity(Class<E> entityClazz) {
		return dto -> map().map(dto, entityClazz);
	}

	@Bean
	public ModelMapper map() {
		return new ModelMapper();
	}
}
