package com.dtb.cadastrocontratos.model.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
