package com.corleone.estoque.repository;

import com.corleone.estoque.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>, JpaSpecificationExecutor<Estoque> {
}