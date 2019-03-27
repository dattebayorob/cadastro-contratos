package com.dtb.cadastrocontratos.model.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "pessoa")
@Data
@Builder
@AllArgsConstructor
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String nome;
	private String referencia;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contrato", nullable = false)
	private Contrato contrato;
	@Column(name = "data_nascimento")
	private Date nascimento;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_condominio")
	private Condominio condominio;
	private String bloco;
	private String apartamento;
	private String cpf;
}
