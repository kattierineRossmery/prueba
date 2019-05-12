package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.repository.IPersonaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Users microservice", description = "This API has a CRUD for users")
@RequestMapping("/personas")
public class RestDemoController {

	@Autowired
	private IPersonaRepository repo;

	@ApiOperation(value = "Retorna lista de Personas")
	@GetMapping
	public List<Persona> listar() {

		List<Persona> list = new ArrayList<>();
		list = repo.findAll();

		return list;
	}
	
	@ApiOperation(value = "Retorna lista de Personas")
	@GetMapping(value = "/listar2", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listar2() {

		List<Persona> list = new ArrayList<>();
		list = repo.findAll();

		return new ResponseEntity<List<Persona>>(list, HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Registra nueva persona")
	@PostMapping
	public void insertar(@RequestBody Persona per) {
		System.out.println("===>>>>XXXXXXXXXXX");
		repo.save(per);
		System.out.println("===>>>>Holiiiii");
	}

	@ApiOperation(value = "Actualiza Persona")
	@PutMapping
	public void modificar(@RequestBody Persona per) {
		repo.save(per);
	}

	@ApiOperation(value = "Elimina Persona")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);

	}
}
