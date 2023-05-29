package com.ufps.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "continente")
public class Continente {
	@Id
	@SequenceGenerator(name="continente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="continente_id_seq")
	private Integer id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "seleccion_id")
	private Seleccion seleccion;

	
	public Continente() {
		
	}
	
	public Continente(Integer id, String nombre, Seleccion seleccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.seleccion = seleccion;
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
}
