package com.dtb.cadastrocontratos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtb.cadastrocontratos.model.entities.Condominio;
import com.dtb.cadastrocontratos.model.repositories.CondominioRepository;
import com.dtb.cadastrocontratos.service.CondominioService;

@Service
public class CondominioServiceImpl implements CondominioService{
	@Autowired
	private CondominioRepository repository;
	@Override
	public List<Condominio> buscarTodos() {
		return repository.findAll();
	}
	@Override
	public Optional<Condominio> buscarPeloId(Long id) {
		return repository.findById(id);
	}
	@Override
	public Condominio persistir(Condominio condominio) {
		return repository.save(condominio);
	}
	@Override
	public void deletar(Long id) {
		repository.deleteById(id);
	}

}
