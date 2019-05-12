package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.IPersonaRepository;
import com.example.demo.service.IPersonaService;

@Service
public class PersonaSeviceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepository repo;

	@Override
	public Persona registrar(Persona persona) {
		return repo.save(persona);
	}

	@Override
	public Persona modificar(Persona persona) {
		return repo.save(persona);
	}

	@Override
	public void eliminar(int id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Persona> listar() {
		return repo.findAll();
	}
}
