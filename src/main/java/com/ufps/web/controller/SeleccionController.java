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
import com.ufps.web.entity.Resultado;
import com.ufps.web.entity.Seleccion;
import com.ufps.web.services.SeleccionService;
import com.ufps.web.repository.SeleccionRepository;
import com.ufps.web.repository.ContinenteRepository;
import com.ufps.web.repository.ResultadoRepository;

import java.util.*;

@Controller
@RequestMapping("/seleccion_view")
public class SeleccionController {
	@Autowired
	private SeleccionService service;
	@Autowired
	private ContinenteRepository continenteRepository;
	@Autowired
	private ResultadoRepository resultadoRepository;
	@Autowired
	private SeleccionRepository seleccionRepository;

	@GetMapping("/list")
	public String listSeleccion(Model model) {
		model.addAttribute("selecciones", service.listAllSelecciones());
		return "index"; // retorna al html con el nombre index
	}

	@GetMapping("/new")
	public String showCreateSeleccion(Model model) {
		Seleccion seleccion = new Seleccion();
		List<Continente> continente = continenteRepository.findAll();
		model.addAttribute("seleccion", seleccion);
		model.addAttribute("continente", continente);
		return "create";
	}

	@PostMapping("/list")
	public String saveCategoria(@ModelAttribute("seleccion") Seleccion seleccion) {
		service.saveSeleccion(seleccion);
		return "redirect:/seleccion_view/list";
	}

	@GetMapping("/edit")
	public String editShowForm(@RequestParam(value = "id", required = false) Integer id, Model model) {
		Seleccion seleccion = new Seleccion();
		if (id != null) {
			seleccion = service.getSeleccionPorId(id);
		}
		if (seleccion == null) {
			return "noExist";
		}
		List<Continente> continente = continenteRepository.findAll();
		model.addAttribute("continente", continente);
		model.addAttribute("seleccion", seleccion);
		return "edit";
	}

	@GetMapping("/delete/{id}")
	public String deleteNews(@PathVariable("id") Integer id, @ModelAttribute("seleccion") Seleccion seleccion,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/seleccion_view/noExist";
		}
		service.deleteSeleccion(id);
		return "redirect:/seleccion_view/list";
	}

	/*
	 * @GetMapping("/result") public String showResultados(Model model) { Resultado
	 * resultado = new Resultado(); model.addAttribute("resultado", resultado);
	 * return "results"; }
	 */
	@GetMapping("/{id}/resultados")
	public String listSelecciones(Model model, @PathVariable("id") Integer id) {
		Seleccion seleccion = service.getSeleccionPorId(id);
		List<Resultado> resultados = resultadoRepository.findBySeleccion(seleccion);

		model.addAttribute("seleccion", seleccion);
		model.addAttribute("resultados", resultados);
		return "results";
	}

	@GetMapping("/grupo/{grupo}")
	public String listGroups(@PathVariable("grupo") String grupo, Model model) {

		List<Seleccion> selecciones = service.listSeleccionesByGroup(grupo);
		model.addAttribute("selecciones", selecciones);

		return "groupList";
	}
	@GetMapping("/selectGroup")
	public String selectGroup(Model model) {
		Seleccion seleccion = new Seleccion();
		model.addAttribute("seleccion", seleccion);
		return "selectGroup";
	}

}