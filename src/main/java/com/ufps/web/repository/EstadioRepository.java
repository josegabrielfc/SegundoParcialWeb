package com.ufps.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufps.web.entity.Estadio;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio,Integer>{

}
