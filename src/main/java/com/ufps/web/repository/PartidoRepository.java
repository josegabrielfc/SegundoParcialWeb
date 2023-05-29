package com.ufps.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufps.web.entity.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido,Integer>{

}
