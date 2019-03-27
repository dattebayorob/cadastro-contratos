package com.dtb.cadastrocontratos.model.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PessoaDto {
	private Long id;
	private String nome;
	private String cpf;
	private String referencia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date nascimento;
	private String contratoContrato;
	private String contratoDataVencimento;
	private String condominioNome;
	private String apartamento;
	private String bloco;
	public PessoaDto() {
		// TODO Auto-generated constructor stub
	}
}
