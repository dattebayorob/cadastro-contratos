package com.dtb.cadastrocontratos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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

import com.dtb.cadastrocontratos.model.dtos.CondominioDto;
import com.dtb.cadastrocontratos.model.dtos.CondominioResumidoDto;
import com.dtb.cadastrocontratos.model.entities.Condominio;
import com.dtb.cadastrocontratos.model.response.Response;
import com.dtb.cadastrocontratos.service.CondominioService;

@RestController
@RequestMapping(value = "/condominios")
@CrossOrigin(origins="*")
public class CondominioController {
	@Autowired
	private CondominioService service;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<CondominioResumidoDto> buscarTodos() {
		List<Condominio> condominios = service.buscarTodos();
		List<CondominioResumidoDto> condominiosDto = new ArrayList<>();
		condominios.forEach(condominio -> condominiosDto.add(modelMapper.map(condominio, CondominioResumidoDto.class)));
		return condominiosDto;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> buscarPeloId(@PathVariable("id") Long id) {
		Optional<Condominio> condominioPeloId = service.buscarPeloId(id);
		if (!condominioPeloId.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(Response.data(modelMapper.map(condominioPeloId.get(), CondominioDto.class)));
	}

	@PostMapping
	public ResponseEntity<Response> adicionar(@Validated @RequestBody CondominioDto condominioDto) {
		Condominio condominio = modelMapper.map(condominioDto, Condominio.class);
		condominio = service.persistir(condominio);
		return new ResponseEntity<>(Response.data(condominio), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Response> atualizar(@PathVariable("id") Long id, @Validated @RequestBody CondominioDto condominioDto) {
		Optional<Condominio> condominioPeloId = service.buscarPeloId(id);
		if (!condominioPeloId.isPresent())
			return ResponseEntity.notFound().build();
		condominioDto.setId(id);
		modelMapper.map(condominioDto, condominioPeloId.get());
		Condominio condominio = service.persistir(condominioPeloId.get());
		return ResponseEntity.ok(Response.data(condominio));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response> deletarPeloId(@PathVariable("id") Long id) {
		if(!service.existePeloId(id))
			return ResponseEntity.notFound().build();
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
