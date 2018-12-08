package com.dtb.cadastrocontratos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApiProperties {
	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
}
