package com.ufps.web.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "resultado")
public class Resultado {
	
	@Id
    @SequenceGenerator(name="resultado_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="resultado_id_seq")
    private Integer id;

    private Integer goles;

    private Integer amarillas;

    private Integer rojas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="partido_id")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name="seleccion_id")
    private Seleccion seleccion;
    
    public Resultado() {
    	
    }
	public Resultado(Integer id, Integer goles, Integer amarillas, Integer rojas, Partido partido,
			Seleccion seleccion) {
		super();
		this.id = id;
		this.goles = goles;
		this.amarillas = amarillas;
		this.rojas = rojas;
		this.partido = partido;
		this.seleccion = seleccion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Seleccion getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Seleccion seleccion) {
		this.seleccion = seleccion;
	}
    
	
}
