package com.corleone.estoque.repository;

import com.corleone.estoque.entity.EstoqueIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueIngredienteRepository extends JpaRepository<EstoqueIngrediente, Integer> {

    Optional<EstoqueIngrediente> findByIngredienteId(Integer ingredienteId);

}