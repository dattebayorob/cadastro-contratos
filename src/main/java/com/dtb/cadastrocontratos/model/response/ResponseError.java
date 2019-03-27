package com.dtb.cadastrocontratos.model.response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.ObjectError;

import lombok.Getter;

@Getter
public class ResponseError implements Response {
	private List<String> errors;

	public ResponseError(List<String> errors) {
		this.errors = errors;
	}

	public static ResponseError error(String error) {
		return new ResponseError(Arrays.asList(error));
	}

	public static ResponseError error(ObjectError error) {
		return new ResponseError(Arrays.asList(error.getDefaultMessage()));
	}

	public static ResponseError errors(List<ObjectError> errors) {
		return new ResponseError(
				errors.stream()
					.map(ObjectError::getDefaultMessage)
					.collect(Collectors.toList())
				);
	}

	public static ResponseError exception(RuntimeException e) {
		throw e;
	}
}
