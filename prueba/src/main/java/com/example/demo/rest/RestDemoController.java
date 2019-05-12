package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.example.demo.service.IPersonaService;

import io.reactivex.Observable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Users microservice", description = "This API has a CRUD for users")
@RequestMapping("/api/v1/personas")
public class RestDemoController {

	@Autowired
	private IPersonaService repo;
	
	@ApiOperation(value = "Retorna lista de Personas")
	@GetMapping(produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Observable<Persona>> listar() {

		List<Persona> list = new ArrayList<>();
		list = repo.listar();
		
		Observable<Persona> obsPersona = Observable.fromIterable(list);

		return new ResponseEntity<Observable<Persona>>(obsPersona, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Persona> listarId(@PathVariable("id") Integer id) {
		return repo.listarId(id);
	}
	
	@ApiOperation(value = "Registra nueva persona")
	@PostMapping
	public void insertar(@RequestBody Persona per) {
		repo.registrar(per);
	}

	@ApiOperation(value = "Actualiza Persona")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String modificar(@RequestBody Persona per) {
		String mensaje = "";
		Optional<Persona> obj = repo.listarId(per.getIdPersona());
		
		if(obj.isPresent()) {
			repo.modificar(per);
			mensaje = "Modificado con éxito!!";
		}else {
			mensaje = "La Persona no existe";
		}
		
		return mensaje;
	}

	@ApiOperation(value = "Elimina Persona")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.eliminar(id);

	}
}
