package com.ufps.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.web.entity.Seleccion;
import com.ufps.web.repository.SeleccionRepository;

@Service
public class SeleccionServiceImplement implements SeleccionService {
	@Autowired
	private SeleccionRepository repository;

	@Override
	public List<Seleccion> listAllSelecciones() {
		return repository.findAll();
	}

	@Override
	public Seleccion saveSeleccion(Seleccion seleccion) {
		return repository.save(seleccion);
	}

	@Override
	public Seleccion getSeleccionPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Seleccion updateSeleccion(Seleccion seleccion) {
		return repository.save(seleccion);
	}

	@Override
	public void deleteSeleccion(Integer id) {
		repository.deleteById(id);
	}

}
