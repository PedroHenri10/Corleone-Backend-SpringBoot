package com.corleone.ingrediente.repository;

import com.corleone.ingrediente.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

}
