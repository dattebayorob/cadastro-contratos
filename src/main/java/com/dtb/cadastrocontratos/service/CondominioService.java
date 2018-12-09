package com.dtb.cadastrocontratos.service;

import java.util.List;
import java.util.Optional;

import com.dtb.cadastrocontratos.model.entities.Condominio;

public interface CondominioService {
	public List<Condominio> buscarTodos();

	public Optional<Condominio> buscarPeloId(Long id);

	public Condominio persistir(Condominio condominio);

	public void deletar(Long id);

	boolean hasCondominio(Long id);
}
