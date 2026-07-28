package com.corleone.estoque.repository;

import com.corleone.estoque.entity.MovimentoIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovimentoIngredienteRepository extends JpaRepository<MovimentoIngrediente, Integer>,
        JpaSpecificationExecutor<MovimentoIngrediente> {
}