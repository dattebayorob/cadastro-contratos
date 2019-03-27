package com.dtb.cadastrocontratos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.cadastrocontratos.model.converters.Converter;
import com.dtb.cadastrocontratos.model.dtos.CondominioDto;
import com.dtb.cadastrocontratos.model.dtos.CondominioResumidoDto;
import com.dtb.cadastrocontratos.model.entities.Condominio;
import com.dtb.cadastrocontratos.model.exceptions.ResourceNotFoundException;
import com.dtb.cadastrocontratos.model.responses.Response;
import com.dtb.cadastrocontratos.model.responses.ResponseData;
import com.dtb.cadastrocontratos.service.CondominioService;

@RestController
@RequestMapping(value = "/condominios")
@CrossOrigin(origins="*")
public class CondominioController {
	@Autowired
	private CondominioService service;
	@Autowired
	private Converter<Condominio, CondominioDto> converter;
	@Autowired
	private Converter<Condominio, CondominioResumidoDto> converterResumido;

	@GetMapping
	public ResponseEntity<Response> buscarTodos() {
		return ResponseEntity.ok(
				ResponseData.data(
				converterResumido.toDto(CondominioResumidoDto.class).convert(service.buscarTodos())
				));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> buscarPeloId(@PathVariable("id") Long id) {
		Condominio condominio = service.buscarPeloId(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));
		return ResponseEntity.ok(
				ResponseData.data(
						converter.toDto(CondominioDto.class).convert(condominio)
						)
				);
	}

	@PostMapping
	public ResponseEntity<Response> adicionar(@Validated @RequestBody CondominioDto dto) {
		Condominio condominio = service
				.persistir(converter
						.toEntity(Condominio.class)
						.convert(dto)
				);
		return new ResponseEntity<>(
				ResponseData.data(converter
						.toDto(CondominioDto.class)
						.convert(condominio)
						), HttpStatus.CREATED
				);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Response> atualizar(@PathVariable("id") Long id, @Validated @RequestBody CondominioDto dto) {
		Condominio condominio = service.buscarPeloId(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));
		dto.setId(id);
		return ResponseEntity.ok(
				ResponseData.data(
						service.persistir(converter.toEntity(condominio).convert(dto))
						)
				);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response> deletarPeloId(@PathVariable("id") Long id) {
		Condominio condominio = service.buscarPeloId(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));
		service.deletar(condominio.getId());
		return ResponseEntity.noContent().build();
	}
}
