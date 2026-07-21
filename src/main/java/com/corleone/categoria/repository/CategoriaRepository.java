package com.corleone.categoria.repository;

import com.corleone.categoria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByCatNomeIgnoreCase(String catNome);

    boolean existsByCatNomeIgnoreCase(String catNome);

    List<Categoria> findAllByCatAtivoTrueOrderByCatNomeAsc();

}