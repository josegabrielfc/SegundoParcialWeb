package com.ufps.web.entity;

import java.sql.Timestamp;
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
@Table(name = "partido")
public class Partido {
	@Id
    @SequenceGenerator(name="partido_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="partido_id_seq")
    private Integer id;

    private Timestamp fecha;

    @JsonIgnore
    @OneToMany(mappedBy="partido")
    private List<Resultado> resultado;

    @ManyToOne
    @JoinColumn(name="estadio_id")
    private Estadio estadio;

	public Partido(Integer id, Timestamp fecha, List<Resultado> resultado, Estadio estadio) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.resultado = resultado;
		this.estadio = estadio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public List<Resultado> getResultado() {
		return resultado;
	}

	public void setResultado(List<Resultado> resultado) {
		this.resultado = resultado;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
    
    
}