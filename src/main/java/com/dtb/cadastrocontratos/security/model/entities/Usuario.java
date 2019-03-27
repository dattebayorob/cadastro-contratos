package com.dtb.cadastrocontratos.security.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dtb.cadastrocontratos.security.model.enums.UsuarioPermissaoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
@Builder
@AllArgsConstructor
public class Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String login;
	private String nome;
	@Column(nullable = false)
	private String senha;
	@Enumerated(EnumType.STRING)
	private UsuarioPermissaoEnum permissao;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
}
