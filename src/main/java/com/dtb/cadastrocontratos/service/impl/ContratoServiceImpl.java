package com.dtb.cadastrocontratos.service.impl;

import java.util.List;
import java.util.Optional;

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
	public boolean existePeloContrato(String contrato) {
		return repository.existsByContrato(contrato);
	}

	@Override
	public List<Contrato> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Contrato buscarPeloContrato(String contrato) {
		return repository.findByContrato(contrato);
	}

	@Override
	public Optional<Contrato> buscarPeloId(Long id) {
		return repository.findById(id);
	}
	
	
}
