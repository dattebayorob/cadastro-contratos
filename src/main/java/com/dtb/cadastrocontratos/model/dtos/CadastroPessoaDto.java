package com.dtb.cadastrocontratos.model.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroPessoaDto {
	private Long id;
	@NotNull(message = "O cpf deve ser informado.")
	@CPF(message = "O cpf informado é invalido")
	private String cpf;
	@NotNull(message = "O nome deve ser informado.")
	@Length(min = 3, max = 255, message = "O nome deve conter entre 3 e 255 caracteres.")
	private String nome;
	private String referencia;
	private Date nascimento;
	@NotNull(message = "O numero do contrato deve ser informado")
	@Length(min = 12, message = "O contrato possui 12 caracteres. Formato: 000000011333")
	private String contratoContrato;
	private String contratoDataVencimento;
	private Long condominioId;
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
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date dataNascimento) {
		this.nascimento = dataNascimento;
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
	
	public Long getCondominioId() {
		return condominioId;
	}
	public void setCondominioId(Long condominioId) {
		this.condominioId = condominioId;
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
