package com.dtb.cadastrocontratos.service;

import java.util.List;
import java.util.Optional;

import com.dtb.cadastrocontratos.model.entities.Contrato;

public interface ContratoService {
	public Contrato persistir(Contrato contrato);
	public List<Contrato> buscarTodos();
	public Optional<Contrato> buscarPeloId(Long id);
	public Contrato buscarPeloContrato(String contrato);
	public boolean existePeloContrato(String contrato);
}
