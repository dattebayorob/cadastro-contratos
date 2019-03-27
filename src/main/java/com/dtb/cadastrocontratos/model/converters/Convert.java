package com.dtb.cadastrocontratos.model.converters;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

}
