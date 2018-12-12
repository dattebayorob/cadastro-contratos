package com.dtb.cadastrocontratos.security.config;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BasicSecurityConfigTest {
	@Autowired
	private PasswordEncoder encoder;
	private static final String SENHA = "user";
	
	@Test
	public void testEncode() {
		String senhaEncriptada = encoder.encode(SENHA);
		System.out.println(senhaEncriptada);
		assertTrue(encoder.matches(SENHA, senhaEncriptada));
	}
	@Test
	public void testDecode() {
		
	}
}
