package com.dtb.cadastrocontratos.security.service.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dtb.cadastrocontratos.security.model.entities.Usuario;
import com.dtb.cadastrocontratos.security.model.entities.UsuarioLogin;
import com.dtb.cadastrocontratos.security.model.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuarioRepository repository;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByLogin(login);
		if(!usuario.isPresent())
			throw new UsernameNotFoundException("Não foi encontrado o usuário para o login "+login);
		
		return new UsuarioLogin(login, usuario.get().getSenha(), Arrays.asList(new SimpleGrantedAuthority(String.valueOf(usuario.get().getPermissao()))), usuario.get());
	}

}
