package com.dtb.cadastrocontratos.model.converters;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public interface Convert<T, R> extends Function<T, R>{
	default R convert(T input) {
		return this.apply(input);
	}
	default List<R> convert(List<T> input) {
		return input
				.stream()
					.map(this::apply)
					.collect(Collectors.toList());
	}
	default Page<R> convert(Page<T> input){
		return input.map(this::apply);
	}

}
