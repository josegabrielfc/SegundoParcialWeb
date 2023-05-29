package com.ufps.web.services;

import java.util.List;

import com.ufps.web.entity.Continente;
import com.ufps.web.entity.Seleccion;

public interface SeleccionService {
	public List<Seleccion> listAllSelecciones();
	
	public Seleccion saveSeleccion(Seleccion category);
	
	public Seleccion getSeleccionPorId(Integer id);
	
	public Seleccion updateSeleccion(Seleccion category);
	
	public void deleteSeleccion(Integer id);
	
}
