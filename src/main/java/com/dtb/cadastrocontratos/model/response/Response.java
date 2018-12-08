package com.dtb.cadastrocontratos.model.response;

import java.util.ArrayList;
import java.util.List;

public class Response {
	private Object data;
	private List<String> errors;
	public Response() {
		// TODO Auto-generated constructor stub
	}
	public Response(Object data) {
		this.data = data;
	}
	public static Response data(Object data) {
		return new Response(data);
	}
	public static Response error(List<String> errors) {
		Response response = new Response();
		errors.forEach(error -> response.getErrors().add(error));
		return response;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public List<String> getErrors() {
		if(errors == null)
			errors = new ArrayList<>();
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
