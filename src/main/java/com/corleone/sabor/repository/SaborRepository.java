package com.corleone.sabor.repository;

import com.corleone.sabor.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface SaborRepository extends JpaRepository<Sabor, Integer>, JpaSpecificationExecutor<Sabor> {

    Optional<Sabor> findByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndIdNot(String nome, Integer id);
}