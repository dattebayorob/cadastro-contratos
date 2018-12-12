package com.dtb.cadastrocontratos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.cadastrocontratos.model.entities.Contrato;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContratoServiceTest {
	private static final String CONTRATO = "000000000004";
	private static final Long ID = Long.valueOf(4);
	@Autowired
	private ContratoService service;
	
	
	@Test
	public void testBuscarPeloIdEqualBuscarPeloContrato() {
		Optional<Contrato> contratoPeloId = service.buscarPeloId(Long.valueOf(ID));
		Contrato contrato = service.buscarPeloContrato(CONTRATO);
		assertEquals(contratoPeloId.get().getId(), contrato.getId());
	}
	@Test
	public void testBuscarPeloIdNotEqualBuscarPeloContrato() {
		Optional<Contrato> contratoPeloId = service.buscarPeloId(Long.valueOf(ID+1));
		Contrato contrato = service.buscarPeloContrato(CONTRATO);
		assertNotEquals(contratoPeloId.get().getId(), contrato.getId());
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
