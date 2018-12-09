package com.dtb.cadastrocontratos.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dtb.cadastrocontratos.model.entities.Pessoa;

public interface PessoaService {
	public Page<Pessoa> buscarTodas(Pageable pageable);
	public Optional<Pessoa> buscarPeloId(Long id);
	public Pessoa persistir(Pessoa pessoa);
}
