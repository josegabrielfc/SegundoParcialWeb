package com.ufps.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufps.web.entity.Continente;
import com.ufps.web.entity.Seleccion;
import com.ufps.web.services.SeleccionService;
import com.ufps.web.repository.SeleccionRepository;
import com.ufps.web.repository.ContinenteRepository;
import java.util.*;

@Controller
@RequestMapping("/seleccion_view")
public class SeleccionController {
	@Autowired
	private SeleccionService service;
	@Autowired
	private SeleccionRepository seleccionRepository;
	@Autowired
    ContinenteRepository continenteRepository;

	@GetMapping("/list")
	public String listSeleccion(Model modelo) {
		modelo.addAttribute("selecciones", service.listAllSelecciones());
		return "index"; // retorna al html con el nombre index
	}

	@GetMapping("/new")
	public String showCreateSeleccion(Model modelo) {
		Seleccion seleccion = new Seleccion();
		List<Continente> continente = continenteRepository.findAll();
		modelo.addAttribute("seleccion", seleccion);
		modelo.addAttribute("continente", continente);
		return "create";
	}
	@PostMapping("/list")
	public String saveCategoria(@ModelAttribute("seleccion") Seleccion seleccion) {
		service.saveSeleccion(seleccion);
		return "redirect:/seleccion_view/list";
	}
	
	@GetMapping("/delete/{id}")
    public String deleteNews(@PathVariable("id") Integer id, @ModelAttribute("seleccion") Seleccion seleccion,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/seleccion_view/noExist";
        }
        seleccionRepository.deleteById(id);
        return "redirect:/seleccion_view/list";
    }
	
	@GetMapping("/showF")
    public String showForm(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Seleccion seleccion = new Seleccion();
        if(id != null) {
            seleccion = seleccionRepository.findById(id).get();
        }
        List<Continente> continente = continenteRepository.findAll();
        model.addAttribute("continente", continente);
        model.addAttribute("seleccion", seleccion);
        return "show";
    }
	
	@PostMapping("/add")
    public String procesarFormulario(Seleccion seleccion, BindingResult result) {
        if (result.hasErrors()) {
            return "show";
        }
        seleccionRepository.save(seleccion);

        return "redirect:/seleccion_view/list";
    }
	
}