package com.corleone.cupom.repository;

import com.corleone.cupom.entity.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CupomRepository extends JpaRepository<Cupom, Integer>, JpaSpecificationExecutor<Cupom> {

    boolean existsByCodigo(String codigo);

    Optional<Cupom> findByCodigo(String codigo);

}