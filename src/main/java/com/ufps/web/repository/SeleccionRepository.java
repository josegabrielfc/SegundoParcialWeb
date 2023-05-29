package com.ufps.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufps.web.entity.Seleccion;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {

}
