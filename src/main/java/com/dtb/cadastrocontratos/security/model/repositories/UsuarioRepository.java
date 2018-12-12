package com.dtb.cadastrocontratos.security.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.cadastrocontratos.security.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByLogin(String login);
}
