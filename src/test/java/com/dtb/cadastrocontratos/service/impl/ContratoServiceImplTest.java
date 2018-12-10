package com.dtb.cadastrocontratos.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.cadastrocontratos.model.entities.Contrato;
import com.dtb.cadastrocontratos.model.repositories.ContratoRepository;
import com.dtb.cadastrocontratos.service.ContratoService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContratoServiceImplTest {
	private static final String CONTRATO = "123456712123";
	@Autowired
	private ContratoService service;
	@Autowired
	private ContratoRepository repository;
	
	
	@Test
	public void testContratoExistsContrato() {
		Optional<Contrato> contratoPeloId = service.buscarPeloId(Long.valueOf(1));
		Contrato contrato = service.buscarPeloContrato(CONTRATO);
		assertEquals(contratoPeloId.get().getDataVencimento(), contrato.getDataVencimento());
	}
	@Test
	public void testBooleanExistsContrato() {
		boolean contrato = service.existePeloContrato(CONTRATO);
		assertTrue(contrato);
	}
	@Test
	public void testBooleanNotExistsContrato() {
		boolean contratoQueNaoExiste = service.existePeloContrato("contratoquenaoexiste");		
		assertFalse(contratoQueNaoExiste);
	}
}