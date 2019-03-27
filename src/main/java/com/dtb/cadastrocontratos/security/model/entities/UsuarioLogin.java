package com.dtb.cadastrocontratos.security.model.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class UsuarioLogin extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuarioLogin(String username, String password, Collection<? extends GrantedAuthority> authorities,Usuario usuario) {
		super(username, password,authorities);
		this.usuario = usuario;
	}
}
