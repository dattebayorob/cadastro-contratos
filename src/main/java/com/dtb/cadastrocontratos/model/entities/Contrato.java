package com.dtb.cadastrocontratos.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "contrato")
@Data
@Builder
@AllArgsConstructor
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "contrato", unique = true, nullable = false)
	private String contrato;
	@Column(name = "dia_vencimento")
	private int dataVencimento;
	public Contrato() {
		// TODO Auto-generated constructor stub
	}
}
