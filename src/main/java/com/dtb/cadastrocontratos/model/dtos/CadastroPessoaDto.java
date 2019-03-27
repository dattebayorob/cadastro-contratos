package com.dtb.cadastrocontratos.model.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CadastroPessoaDto {
	private Long id;
	@NotNull(message = "O cpf deve ser informado.")
	@CPF(message = "O cpf informado é invalido")
	private String cpf;
	@NotNull(message = "O nome deve ser informado.")
	@Length(min = 3, max = 255, message = "O nome deve conter entre 3 e 255 caracteres.")
	private String nome;
	private String referencia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date nascimento;
	private Long contratoId;
	@NotNull(message = "O numero do contrato deve ser informado")
	@Length(min = 12, message = "O contrato possui 12 caracteres. Formato: 000000011333")
	private String contratoContrato;
	private String contratoDataVencimento;
	private Long condominioId;
	private String apartamento;
	private String bloco;
}
