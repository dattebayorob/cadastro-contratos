package com.dtb.cadastrocontratos.security.model.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioLogin extends User{
	
	private Usuario usuario;
	
	public UsuarioLogin(String username, String password, Collection<? extends GrantedAuthority> authorities,Usuario usuario) {
		super(username, password,authorities);
		this.usuario = usuario;
	}
}
