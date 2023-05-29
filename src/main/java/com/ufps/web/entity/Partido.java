package com.ufps.web.entity;

import java.sql.Timestamp;
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
@Table(name = "partido")
public class Partido {
	@Id
	@SequenceGenerator(name="continente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="continente_id_seq")
	private Integer id;
	private Timestamp fecha;
	
	@OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
	private List<Estadio> estadio;
	
	@ManyToOne
	@JoinColumn(name = "resultado_id")
	private Resultado resultado;

	public Partido(Integer id, Timestamp fecha, List<Estadio> estadio, Resultado resultado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estadio = estadio;
		this.resultado = resultado;
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

	public List<Estadio> getEstadio() {
		return estadio;
	}

	public void setEstadio(List<Estadio> estadio) {
		this.estadio = estadio;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
}
