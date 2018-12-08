package com.dtb.cadastrocontratos.model.dtos;

public class PessoaDto {
	private Long id;
	private String nome;
	private String cpf;
	private String referencia;
	private String dataNascimento;
	private String contratoContrato;
	private String contratoDataVencimento;
	private String condominioNome;
	private String apartamento;
	private String bloco;
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
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getCondominioNome() {
		return condominioNome;
	}
	public void setCondominioNome(String condominioNome) {
		this.condominioNome = condominioNome;
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
