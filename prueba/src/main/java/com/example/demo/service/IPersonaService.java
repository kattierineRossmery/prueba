package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Persona;

public interface IPersonaService {


	Persona registrar(Persona persona);
	
	Persona modificar(Persona persona);

	void eliminar(int id);

	Optional<Persona> listarId(int id);

	List<Persona> listar();
	
	
}
