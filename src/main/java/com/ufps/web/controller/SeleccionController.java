package com.ufps.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufps.web.entity.Seleccion;
import com.ufps.web.services.SeleccionService;

@Controller
@RequestMapping("/seleccion_view")
public class SeleccionController {
	@Autowired
	private SeleccionService service;

	@GetMapping("/list")
	public String listSeleccion(Model modelo) {
		modelo.addAttribute("selecciones", service.listAllSelecciones());
		return "index"; // retorna al html con el nombre index
	}

	@GetMapping("/new")
	public String showCreateSeleccion(Model modelo) {
		Seleccion seleccion = new Seleccion();
		modelo.addAttribute("seleccion", seleccion);
		return "create";
	}
	@PostMapping("/list")
	public String saveCategoria(@ModelAttribute("seleccion") Seleccion seleccion) {
		service.saveSeleccion(seleccion);
		return "redirect:/seleccion_view/list";
	}
	
	
}