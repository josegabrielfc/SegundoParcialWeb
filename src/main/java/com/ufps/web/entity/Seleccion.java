package com.ufps.web.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "seleccion")
public class Seleccion {
	@Id
	@SequenceGenerator(name="seleccion_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seleccion_id_seq")
	private Integer id;
	private String nombre;
	
	
	@OneToMany(mappedBy = "seleccion", cascade = CascadeType.ALL)
	private List<Continente> continentes;
	
	private String grupo;
	
	@ManyToOne
	@JoinColumn(name = "resultado_id")
	private Resultado resultado;
	
	public Seleccion() {
	}

	public Seleccion(Integer id, String nombre, List<Continente> continentes, String grupo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.continentes = continentes;
		this.grupo = grupo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<Continente> getContinente() {
		return continentes;
	}

	public void setContinente(List<Continente> continente) {
		this.continentes = continente;
	}
	
}
