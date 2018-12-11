package com.dtb.cadastrocontratos.service;

import java.util.List;
import java.util.Optional;

import com.dtb.cadastrocontratos.model.entities.Contrato;

public interface ContratoService {

	/**
	 * 
	 * Persistir uma entidade Contrato no banco de dados
	 * 
	 * @param contrato
	 * @return Contrato
	 * 
	 */

	public Contrato persistir(Contrato contrato);

	/**
	 * 
	 * Buscar todas as entidades Contrato do banco de dados
	 * 
	 * @return List<Contrato>
	 * 
	 */

	public List<Contrato> buscarTodos();

	/**
	 * 
	 * Buscar uma entidade Contrato pelo id
	 * 
	 * @param id
	 * @return Optional<Contrato>
	 * 
	 */

	public Optional<Contrato> buscarPeloId(Long id);

	/**
	 * 
	 * Buscar uma entidade Contrato de acordo com o contrato(String)
	 * 
	 * @param contrato
	 * 
	 * @return Contrato
	 * 
	 */

	public Contrato buscarPeloContrato(String contrato);

	/**
	 * 
	 * Verificar se existe uma entidade Contrato pelo contrato
	 * 
	 * @param contrato
	 * @return boolean
	 * 
	 */

	public boolean existePeloContrato(String contrato);
}
