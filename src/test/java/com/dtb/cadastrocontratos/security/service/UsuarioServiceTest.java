package com.dtb.cadastrocontratos.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.cadastrocontratos.security.model.entities.Usuario;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioServiceTest {
	@Autowired
	private UsuarioService service;
	private static final String LOGIN = "adminnnnn";
	private static final Long ID = Long.valueOf(1);
	
	@Test
	public void buscarPeloLoginTest() {
		Optional<Usuario> uPeloLogin = service.buscarPeloLogin(LOGIN);
		assertNotNull(uPeloLogin.get());
	}
	@Test
	public void buscarPeloIdTest() {
		Optional<Usuario> uPeloId = service.buscarPeloId(ID);
		assertNotNull(uPeloId.get());
	}
	@Test
	public void usuarioPeloLoginIgualUsuarioPeloId() {
		Optional<Usuario> uPeloLogin = service.buscarPeloLogin(LOGIN);
		Optional<Usuario> uPeloId = service.buscarPeloId(uPeloLogin.get().getId());
		assertEquals(service.buscarPeloId(ID).get().getId(), uPeloId.get().getId());
	}
	
}
