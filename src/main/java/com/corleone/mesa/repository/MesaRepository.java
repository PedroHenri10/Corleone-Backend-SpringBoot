package com.corleone.mesa.repository;

import com.corleone.mesa.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MesaRepository extends JpaRepository<Mesa, Integer>, JpaSpecificationExecutor<Mesa> {
    Optional<Mesa> findByNumero(Integer numero);

    boolean existsByNumero(Integer numero);

    boolean existsByNumeroAndIdNot(Integer numero, Integer id);
}
