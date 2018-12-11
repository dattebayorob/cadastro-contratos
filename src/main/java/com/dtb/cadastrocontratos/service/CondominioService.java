package com.dtb.cadastrocontratos.service;

import java.util.List;
import java.util.Optional;

import com.dtb.cadastrocontratos.model.entities.Condominio;

public interface CondominioService {

	/**
	 * 
	 * Buscar todas as entidades de Condominio
	 * 
	 * @return List<Condominio>
	 * 
	 */
	public List<Condominio> buscarTodos();

	/**
	 * 
	 * Buscar uma entidade Condominio pelo id
	 * 
	 * @param id
	 * @return Optional<Condominio>
	 * 
	 */
	public Optional<Condominio> buscarPeloId(Long id);

	/**
	 * 
	 * Persistir uma entidade Condominio no banco de dados
	 * 
	 * @param condominio
	 * @return Condominio
	 * 
	 */
	public Condominio persistir(Condominio condominio);

	/**
	 * 
	 * Deletar uma entidade do banco de dados
	 * 
	 * @param id
	 * 
	 */
	public void deletar(Long id);

	/**
	 * Verificar se existe uma entidade Condominio para o id informado
	 * 
	 * @param id
	 * @return boolean
	 * 
	 */
	public boolean existePeloId(Long id);
}
