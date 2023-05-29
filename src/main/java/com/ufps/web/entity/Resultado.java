package com.ufps.web.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultado")
public class Resultado {
	
	@Id
	@SequenceGenerator(name="continente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="continente_id_seq")
	private Integer id;
	
	@OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL)
	private List<Partido> partido;
	
	@OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL)
	private List<Seleccion> seleccion;
	
	private Integer goles;
	private Integer amarillas;
	private Integer rojas;
	public Resultado(Integer id, List<Partido> partido, List<Seleccion> seleccion, Integer goles, Integer amarillas,
			Integer rojas) {
		super();
		this.id = id;
		this.partido = partido;
		this.seleccion = seleccion;
		this.goles = goles;
		this.amarillas = amarillas;
		this.rojas = rojas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Partido> getPartido() {
		return partido;
	}
	public void setPartido(List<Partido> partido) {
		this.partido = partido;
	}
	public List<Seleccion> getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(List<Seleccion> seleccion) {
		this.seleccion = seleccion;
	}
	public Integer getGoles() {
		return goles;
	}
	public void setGoles(Integer goles) {
		this.goles = goles;
	}
	public Integer getAmarillas() {
		return amarillas;
	}
	public void setAmarillas(Integer amarillas) {
		this.amarillas = amarillas;
	}
	public Integer getRojas() {
		return rojas;
	}
	public void setRojas(Integer rojas) {
		this.rojas = rojas;
	}
	
	
}
