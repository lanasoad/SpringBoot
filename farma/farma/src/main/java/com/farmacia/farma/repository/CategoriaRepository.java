package com.farmacia.farma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.farma.model.Categoria;

@Repository 
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
