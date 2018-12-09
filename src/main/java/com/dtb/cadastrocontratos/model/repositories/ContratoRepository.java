package com.dtb.cadastrocontratos.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.cadastrocontratos.model.entities.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
	List<Contrato> findByContrato(String contrato);
	//boolean existsContrato(@Param("contrato") String contrato);

}
