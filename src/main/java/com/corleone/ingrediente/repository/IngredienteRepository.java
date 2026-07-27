package com.corleone.ingrediente.repository;

import com.corleone.ingrediente.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>, JpaSpecificationExecutor<Ingrediente> {
    Optional<Ingrediente> findByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndIdNot(String nome, Integer id);
}
