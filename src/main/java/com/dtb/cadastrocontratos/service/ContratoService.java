package com.dtb.cadastrocontratos.service;

import com.dtb.cadastrocontratos.model.entities.Contrato;

public interface ContratoService {
	public Contrato persistir(Contrato contrato);
	public boolean existsContrato(String contrato);
}
