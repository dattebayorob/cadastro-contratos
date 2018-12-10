package com.dtb.cadastrocontratos.service;

import java.util.List;

import com.dtb.cadastrocontratos.model.entities.Contrato;

public interface ContratoService {
	public Contrato persistir(Contrato contrato);
	public List<Contrato> buscarTodos();
	public Contrato buscarPeloContrato(String contrato);
	public boolean existePeloContrato(String contrato);
}
