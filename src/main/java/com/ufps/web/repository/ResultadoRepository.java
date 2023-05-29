package com.ufps.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufps.web.entity.Resultado;
import com.ufps.web.entity.Seleccion;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado,Integer>{
	List<Resultado> findBySeleccion(Seleccion seleccion);
}
