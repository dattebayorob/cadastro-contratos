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

@Entity
@Table(name = "usuario")
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioPermissaoEnum getPermissao() {
		return permissao;
	}
	public void setPermissao(UsuarioPermissaoEnum permissao) {
		this.permissao = permissao;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", nome=" + nome + ", senha=" + senha + ", permissao="
				+ permissao + "]";
	}
	
	
}
