package com.dtb.cadastrocontratos.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtb.cadastrocontratos.security.model.entities.Usuario;
import com.dtb.cadastrocontratos.security.model.repositories.UsuarioRepository;
import com.dtb.cadastrocontratos.security.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Optional<Usuario> buscarPeloLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public Optional<Usuario> buscarPeloId(Long id) {
		return repository.findById(id);
	}
	
}
