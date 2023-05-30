package com.ufps.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ufps.web.entity.Seleccion;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {
	//@Query("SELECT s FROM Seleccion s JOIN FETCH s.continente c")
    //List<Seleccion> findAllWithContinente();
	List<Seleccion> findByGrupo(String grupo);

	@Query("SELECT DISTINCT s.grupo FROM Seleccion s")
    List<String> findDistinctGrupos();
}
