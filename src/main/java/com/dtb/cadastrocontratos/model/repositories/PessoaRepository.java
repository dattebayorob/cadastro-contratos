package com.dtb.cadastrocontratos.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.cadastrocontratos.model.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
