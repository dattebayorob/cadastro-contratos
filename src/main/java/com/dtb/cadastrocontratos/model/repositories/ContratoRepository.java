package com.dtb.cadastrocontratos.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.cadastrocontratos.model.entities.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long>{

}
