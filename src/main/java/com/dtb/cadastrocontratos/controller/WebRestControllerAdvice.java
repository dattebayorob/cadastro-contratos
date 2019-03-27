package com.dtb.cadastrocontratos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.dtb.cadastrocontratos.model.exceptions.ResourceNotFoundException;
import com.dtb.cadastrocontratos.model.responses.Response;
import com.dtb.cadastrocontratos.model.responses.ResponseError;

@RestControllerAdvice
public class WebRestControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		return ResponseError.errors(ex.getBindingResult().getAllErrors());
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Response handleResponseStatusException(ResponseStatusException ex) {
		return ResponseError.error(ex.getMessage());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Response handleResourceNotFoundException(ResourceNotFoundException ex) {
		return ResponseError.error(ex.getMessage());
	}
}
