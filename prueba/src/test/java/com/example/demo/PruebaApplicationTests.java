package com.example.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Usuario;
import com.example.demo.repository.IUsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaApplicationTests {

	@Autowired
	private IUsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		Usuario usa =new Usuario();
		usa.setId(3);
		usa.setNombre("rvega");
		usa.setClave(encoder.encode("445"));
		Usuario retorno = repo.save(usa);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(usa.getClave()));
	}

}
