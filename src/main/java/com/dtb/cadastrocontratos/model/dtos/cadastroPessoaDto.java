package com.dtb.cadastrocontratos.model.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class cadastroPessoaDto {
	private Long id;
	@NotNull(message = "O cpf deve ser informado.")
	@CPF(message = "O cpf informado é invalido")
	private String cpf;
	@NotNull(message = "O nome deve ser informado.")
	@Length(min = 3, max = 255, message = "O nome deve conter entre 3 e 255 caracteres.")
	private String nome;
	private String referencia;
	private String dataNascimento;
	@NotNull(message = "O numero do contrato deve ser informado")
	@Length(min = 12, message = "O contrato possui 12 caracteres. Formato: 000000011333")
	private String contratoContrato;
	private String contratoDataVencimento;
	private Long id_condominio;
	private String apartamento;
	private String bloco;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getContratoContrato() {
		return contratoContrato;
	}
	public void setContratoContrato(String contratoContrato) {
		this.contratoContrato = contratoContrato;
	}
	public String getContratoDataVencimento() {
		return contratoDataVencimento;
	}
	public void setContratoDataVencimento(String contratoDataVencimento) {
		this.contratoDataVencimento = contratoDataVencimento;
	}
	public Long getId_condominio() {
		return id_condominio;
	}
	public void setId_condominio(Long id_condominio) {
		this.id_condominio = id_condominio;
	}
	public String getApartamento() {
		return apartamento;
	}
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	
}
