package com.dtb.cadastrocontratos.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.cadastrocontratos.model.converters.Converter;
import com.dtb.cadastrocontratos.model.exceptions.ResourceNotFoundException;
import com.dtb.cadastrocontratos.model.responses.Response;
import com.dtb.cadastrocontratos.model.responses.ResponseData;
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
	private Converter<Usuario, UsuarioDto> converter;

	@GetMapping(value = "/{login}")
	public ResponseEntity<Response> buscarPeloId(@PathVariable("login") String login) {
		Usuario usuario = service.buscarPeloLogin(login).orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));

		return ResponseEntity.ok(
				ResponseData.data(
						converter.toDto(UsuarioDto.class).convert(usuario)
						)
				);
	}
}
