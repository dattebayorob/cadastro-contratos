package com.dtb.cadastrocontratos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtb.cadastrocontratos.model.entities.Contrato;
import com.dtb.cadastrocontratos.model.repositories.ContratoRepository;
import com.dtb.cadastrocontratos.service.ContratoService;
@Service
public class ContratoServiceImpl implements ContratoService{
	@Autowired
	private ContratoRepository repository;
	
	@Override
	public Contrato persistir(Contrato contrato) {
		return repository.save(contrato);
	}

	@Override
	public boolean existsContrato(String contrato) {
		//To achando meio gambiarra...
		List<Contrato> contratos = repository.findByContrato(contrato);
		return !contratos.isEmpty();
	}
	
	
}
