package com.corleone.tamanho.repository;

import com.corleone.tamanho.entity.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TamanhoRepository extends JpaRepository<Tamanho, Integer> {

    Optional<Tamanho> findByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndIdNot(String nome, Integer id);

}