package com.ufps.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufps.web.entity.Continente;

@Repository
public interface ContinenteRepository extends JpaRepository<Continente,Integer> {
	
}