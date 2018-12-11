package com.dtb.cadastrocontratos.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dtb.cadastrocontratos.model.entities.Pessoa;
import com.dtb.cadastrocontratos.model.repositories.PessoaRepository;
import com.dtb.cadastrocontratos.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{
	@Autowired
	private PessoaRepository repository;

	@Override
	public Pessoa persistir(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	@Override
	public Page<Pessoa> buscarTodas(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<Pessoa> buscarPeloId(Long id) {
		 return repository.findById(id);
	}

	@Override
	public boolean existe(Long id) {
		return repository.existsById(id);
	}

	@Override
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
