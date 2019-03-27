package com.dtb.cadastrocontratos.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "condominio")
@Data
@Builder
@AllArgsConstructor
public class Condominio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String endereco;
	private String numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
}
