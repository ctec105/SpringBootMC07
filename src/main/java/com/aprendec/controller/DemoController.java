package com.aprendec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aprendec.model.Persona;
import com.aprendec.repository.IPersonaRepo;

@Controller
public class DemoController {

	@Autowired
	private IPersonaRepo personaRepo;
	
	@GetMapping("/greeting")
	public String greeting(
							@RequestParam(name = "name", required = false, defaultValue = "World") String name,
							Model model
						  ) 
	{
		Persona p = new Persona();
		p.setId(2);
		p.setNombre("Gabriela");
		personaRepo.save(p);
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String greeting(Model model) {
		// lógica
		model.addAttribute("personas", personaRepo.findAll());
		return "greeting";
	}
}
