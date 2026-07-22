package com.corleone.borda.repository;

import com.corleone.borda.entity.Borda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BordaRepository extends JpaRepository<Borda, Integer> {

    Optional<Borda> findByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndIdNot(String nome, Integer id);

}