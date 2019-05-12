package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Persona;
import com.example.demo.repository.IPersonaRepository;

@Controller
@RequestMapping("/hola")
public class controllerBasic {

	///igorejgierojgoiergj
	///
	//
	
	@Autowired
	private IPersonaRepository repo;
	
	@GetMapping(path = {"/saludar", "/holamundo"})
	public String saludar(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model) {
		
		//logica
		Persona per= new Persona();
		per.setIdPersona(1);
		per.setDni("12345678");
		per.setNombre("Rosmery");
		repo.save(per);
		
		model.addAttribute("nombre", name);
		return "index";
	}

		@GetMapping("/listar")
		public String listar(Model model){
				
				//logica
			model.addAttribute("personas",repo.findAll());
				
				return "index";
			}
}
