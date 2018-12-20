package com.dtb.cadastrocontratos.model.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ValidationErrorException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1970664207041614497L;
	private List<ObjectError> errors;
	
	public ValidationErrorException(List<ObjectError> errors) {
		super();
		this.errors = errors;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}
	
}
