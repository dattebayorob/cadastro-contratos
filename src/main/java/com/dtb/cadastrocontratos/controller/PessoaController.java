package com.dtb.cadastrocontratos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.cadastrocontratos.model.dtos.CadastroPessoaDto;
import com.dtb.cadastrocontratos.model.dtos.PessoaDto;
import com.dtb.cadastrocontratos.model.entities.Pessoa;
import com.dtb.cadastrocontratos.model.response.Response;
import com.dtb.cadastrocontratos.service.ContratoService;
import com.dtb.cadastrocontratos.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private ContratoService contratoService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<Response> buscarTodos() {
		return null;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> buscarPeloId(@PathVariable("id") Long id) {
		Optional<Pessoa> pessoa = pessoaService.buscarPeloId(id);
		if (!pessoa.isPresent())
			return ResponseEntity.notFound().build();
		PessoaDto pessoaDto = modelMapper.map(pessoa.get(), PessoaDto.class);
		return ResponseEntity.ok(Response.data(pessoaDto));
	}

	@PostMapping
	public ResponseEntity<Response> adicionar(@RequestBody CadastroPessoaDto pessoaDto, BindingResult result) {
		validarDadosPessoa(pessoaDto, result);
		if (result.hasErrors()) {
			new Response();
			List<String> errors = new ArrayList<>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(Response.error(errors));
		}
		Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);
		pessoa = pessoaService.persistir(pessoa);
		return ResponseEntity.ok(Response.data(modelMapper.map(pessoa, PessoaDto.class)));
	}

	private void validarDadosPessoa(CadastroPessoaDto pessoaDto, BindingResult result) {
		if(contratoService.existePeloContrato(pessoaDto.getContratoContrato())) {
			result.addError(new ObjectError("contrato", "contrato já existe"));
		}
	}
}
