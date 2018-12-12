package com.dtb.cadastrocontratos.security.service;

import java.util.Optional;

import com.dtb.cadastrocontratos.security.model.entities.Usuario;

public interface UsuarioService {
	public Optional<Usuario> buscarPeloLogin(String login);
	public Optional<Usuario> buscarPeloId(Long id);
}
