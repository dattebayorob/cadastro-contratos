package com.dtb.cadastrocontratos.model.response;

import lombok.Getter;

@Getter
public class ResponseData implements Response{
	private Object data;
	public ResponseData() {
		// TODO Auto-generated constructor stub
	}
	public ResponseData(Object data) {
		this.data = data;
	}
	public static ResponseData data(Object data) {
		return new ResponseData(data);
	}
	
}
