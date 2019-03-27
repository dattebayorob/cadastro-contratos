package com.dtb.cadastrocontratos.model.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CondominioDto {
	private Long id;
	@NotNull(message = "O nome deve ser informado.")
	@Length(min = 5, max = 255, message = "O nome deve conter entre 5 e 255 caracteres.")
	private String nome;
	@NotNull(message = "O endereço deve ser informado.")
	private String endereco;
	@NotNull(message = "O numero deve ser informado.")
	private String numero;
	@NotNull(message = "O cep deve ser informado.")
	private String cep;
	@NotNull(message = "O bairro deve ser informado.")
	private String bairro;
	@NotNull(message = "A cidade deve ser informada.")
	private String cidade;
	@NotNull(message = "O estado deve ser informado.")
	private String estado;
	public CondominioDto() {
		// TODO Auto-generated constructor stub
	}
}
