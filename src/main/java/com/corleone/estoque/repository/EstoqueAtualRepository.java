package com.corleone.estoque.repository;

import com.corleone.estoque.entity.EstoqueAtual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueAtualRepository extends JpaRepository<EstoqueAtual, Integer> {

    Optional<EstoqueAtual> findByProdutoId(Integer produtoId);

}