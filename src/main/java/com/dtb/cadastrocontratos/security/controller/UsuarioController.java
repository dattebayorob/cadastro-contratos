package com.dtb.cadastrocontratos.security.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.cadastrocontratos.model.response.Response;
import com.dtb.cadastrocontratos.security.model.dtos.UsuarioDto;
import com.dtb.cadastrocontratos.security.model.entities.Usuario;
import com.dtb.cadastrocontratos.security.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@CrossOrigin(origins = "*")
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/{login}")
	public ResponseEntity<Response> buscarPeloId(@PathVariable("login") String login) {
		Optional<Usuario> usuario = service.buscarPeloLogin(login);
		if(!usuario.isPresent())
			return ResponseEntity.notFound().build();
		UsuarioDto dto = modelMapper.map(usuario.get(), UsuarioDto.class);
		return ResponseEntity.ok(Response.data(dto));
	}
}
