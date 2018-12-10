package com.dtb.cadastrocontratos.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "contrato", unique = true, nullable = false)
	private String contrato;
	@Column(name = "dia_vencimento")
	private int dataVencimento;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public int getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(int dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
}
