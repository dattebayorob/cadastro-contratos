package com.dtb.cadastrocontratos.model.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dtb.cadastrocontratos.model.entities.Contrato;

@NamedQueries({
	@NamedQuery(name = "ContratoRepository.existsByContrato", 
		query = "SELECT CASE WHEN EXISTS (SELECT c.contrato FROM contrato c WHERE contrato.contrato = :contrato) THEN 'true' ELSE 'false' END"),
	@NamedQuery(name = "ContratoRepository.findByContrato", 
		query = "SELECT c FROM contrato c WHERE c.contrato = :contrato")
})
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
	//List<Contrato> findByContrato(String contrato);
	Contrato findByContrato(@Param("contrato") String contrato);
	boolean existsByContrato(@Param("contrato") String contrato);

}
