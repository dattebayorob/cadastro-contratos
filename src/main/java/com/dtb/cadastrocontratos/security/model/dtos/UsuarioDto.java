package com.dtb.cadastrocontratos.security.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UsuarioDto {
	private Long id;
	private String nome;
	private String login;
	private String permissao;
	public UsuarioDto() {
		// TODO Auto-generated constructor stub
	}
}
