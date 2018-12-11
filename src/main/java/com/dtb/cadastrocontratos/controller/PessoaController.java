package com.dtb.cadastrocontratos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.cadastrocontratos.model.dtos.CadastroPessoaDto;
import com.dtb.cadastrocontratos.model.dtos.PessoaDto;
import com.dtb.cadastrocontratos.model.entities.Contrato;
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
	public ResponseEntity<Response> buscarTodos(
			@RequestParam(value = "index", defaultValue = "0") int index,
			@RequestParam(value = "size", defaultValue = "5") int size,
			@RequestParam(value = "order", defaultValue = "id") String order,
			@RequestParam(value = "dir", defaultValue = "ASC") String dir) {
		Page<Pessoa> pessoas = pessoaService.buscarTodas(PageRequest.of(index, size,Direction.valueOf(dir),order));
		if(pessoas.isEmpty())
			return ResponseEntity.noContent().build();
		Page<PessoaDto> pessoasDto = pessoas.map(pessoa -> modelMapper.map(pessoa, PessoaDto.class));
		return ResponseEntity.ok(Response.data(pessoasDto)); 
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> buscarPeloId(@PathVariable("id") Long id) {
		Optional<Pessoa> pessoa = pessoaService.buscarPeloId(id);
		if (!pessoa.isPresent())
			return ResponseEntity.notFound().build();
		PessoaDto pessoaDto = modelMapper.map(pessoa.get(), PessoaDto.class);
		return ResponseEntity.ok(Response.data(pessoaDto));
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response> atualizar(@PathVariable("id") Long id, @Validated @RequestBody CadastroPessoaDto cPessoaDto, BindingResult result){
		Optional<Pessoa> pessoaPeloId = pessoaService.buscarPeloId(id);
		if(!pessoaPeloId.isPresent())
			return ResponseEntity.notFound().build();
		if(!cPessoaDto.getContratoContrato().equals(pessoaPeloId.get().getContrato().getContrato()))
			validarContrato(cPessoaDto.getContratoContrato(), result);
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(Response.error(result.getAllErrors()));
		}
		Pessoa pessoa = modelMapper.map(cPessoaDto, Pessoa.class);
		pessoa.setId(pessoaPeloId.get().getId());
		pessoa = pessoaService.persistir(pessoa);
		return ResponseEntity.ok(Response.data(modelMapper.map(pessoa, PessoaDto.class)));
	}

	@PostMapping
	public ResponseEntity<Response> adicionar(@Validated @RequestBody CadastroPessoaDto pessoaDto, BindingResult result) {
		validarContrato(pessoaDto.getContratoContrato(), result);
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(Response.error(result.getAllErrors()));
		}
		Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);
		pessoa = pessoaService.persistir(pessoa);
		return ResponseEntity.ok(Response.data(modelMapper.map(pessoa, PessoaDto.class)));
	}

	private void validarContrato(String contrato, BindingResult result) {
		if(contratoService.existePeloContrato(contrato)) {
			result.addError(new ObjectError("contrato", "contrato já existe"));
		}
	}
}
