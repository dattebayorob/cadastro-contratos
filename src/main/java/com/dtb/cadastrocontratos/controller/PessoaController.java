package com.dtb.cadastrocontratos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dtb.cadastrocontratos.model.converters.Converter;
import com.dtb.cadastrocontratos.model.dtos.CadastroPessoaDto;
import com.dtb.cadastrocontratos.model.dtos.PessoaDto;
import com.dtb.cadastrocontratos.model.entities.Pessoa;
import com.dtb.cadastrocontratos.model.exceptions.ResourceNotFoundException;
import com.dtb.cadastrocontratos.model.responses.Response;
import com.dtb.cadastrocontratos.model.responses.ResponseData;
import com.dtb.cadastrocontratos.service.ContratoService;
import com.dtb.cadastrocontratos.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
@CrossOrigin(origins="*")
public class PessoaController {
	@Autowired
	private PessoaService service;
	@Autowired
	private ContratoService contratoService;
	@Autowired
	private Converter<Pessoa, PessoaDto> converter;
	@Autowired
	private Converter<Pessoa, CadastroPessoaDto> cadastroConverter;

	@GetMapping
	public ResponseEntity<Response> buscarTodos(
			@RequestParam(value = "index", defaultValue = "0") int index,
			@RequestParam(value = "size", defaultValue = "5") int size,
			@RequestParam(value = "order", defaultValue = "id") String order,
			@RequestParam(value = "dir", defaultValue = "ASC") String dir) {
		Page<Pessoa> pessoas = service.buscarTodas(PageRequest.of(index, size,Direction.valueOf(dir),order));
		if(pessoas.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(
				ResponseData.data(
						converter.toDto(PessoaDto.class).convert(pessoas)
						)
				);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> buscarPeloId(@PathVariable("id") Long id) {
		Pessoa pessoa = service.buscarPeloId(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));
		return ResponseEntity.ok(
				ResponseData.data(
						converter.toDto(PessoaDto.class).convert(pessoa)
						)
				);
	}
	
	/**
	 * 
	 * Atualizar informações de uma Pessoa com as informações repassadas pelo frontend
	 * 
	 * 	 
	 * 
	 * @param id
	 * @param cPessoaDto
	 * @param result
	 * @return ResponseEntity
	 * 
	 * 
	 * 
	 * */
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response> atualizar(@PathVariable("id") Long id, @Validated @RequestBody CadastroPessoaDto dto){
		Pessoa pessoa = service.buscarPeloId(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));
		
		// TODO: Regra de negócio deve estar no service
		if(!dto.getContratoContrato().equals(pessoa.getContrato().getContrato()))
			validarContrato(dto.getContratoContrato());
		dto.setId(id);
		return ResponseEntity.ok(
				ResponseData.data(
						service.persistir(cadastroConverter.toEntity(pessoa).convert(dto))
						)
				);
	}

	@PostMapping
	public ResponseEntity<Response> adicionar(@Validated @RequestBody CadastroPessoaDto dto) {
		validarContrato(dto.getContratoContrato());
		Pessoa pessoa = cadastroConverter.toEntity(Pessoa.class).convert(dto);
		return new ResponseEntity<Response>(
				ResponseData.data(
						cadastroConverter.toDto(CadastroPessoaDto.class).convert(service.persistir(pessoa))
						), HttpStatus.CREATED
				);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response> deletar(@PathVariable("id") Long id){
		Pessoa pessoa = service.buscarPeloId(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));

		service.deletar(pessoa.getId());
		return ResponseEntity.noContent().build();
	}
	

	private void validarContrato(String contrato) {
		if(contratoService.existePeloContrato(contrato)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "contrato já existe");
		}
	}
}
