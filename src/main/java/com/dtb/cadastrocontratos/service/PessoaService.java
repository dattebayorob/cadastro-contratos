package com.dtb.cadastrocontratos.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dtb.cadastrocontratos.model.entities.Pessoa;

public interface PessoaService {
	
	/**
	 * 
	 * Retornar todas as entidades de Pessoa paginadas
	 * 
	 * @param pageable
	 * @return Page<Pessoa>
	 * 
	 * */
	
	public Page<Pessoa> buscarTodas(Pageable pageable);
	
	/**
	 * 
	 * Buscar uma entidade Pessoa pelo id
	 * 
	 * @param id
	 * @return Optional<Pessoa>
	 * 
	 * */
	
	public Optional<Pessoa> buscarPeloId(Long id);
	
	/**
	 * 
	 * Persitir uma entidade Pessoa no banco de dados
	 * 
	 * @param pessoa
	 * @return Pessoa
	 * 
	 * */
	
	public Pessoa persistir(Pessoa pessoa);
	
	/**
	 * 
	 * Verificar a existencia de uma entidade pessoa pelo id
	 * @param id
	 * @return boolean
	 * 
	 * */
	
	public boolean existe(Long id);
	
	/**
	 * 
	 * Deletar uma entidade do banco de dados pelo id
	 * @param id
	 * 
	 * */
	
	public void deletar(Long id);
}
