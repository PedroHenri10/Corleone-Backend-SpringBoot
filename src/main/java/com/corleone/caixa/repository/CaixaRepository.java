package com.corleone.caixa.repository;

import com.corleone.caixa.entity.Caixa;
import com.corleone.shared.enums.StatusCaixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CaixaRepository extends JpaRepository<Caixa, Integer>, JpaSpecificationExecutor<Caixa> {

    Optional<Caixa> findFirstByStatusOrderByDataAberturaDesc(StatusCaixa status);

    Optional<Caixa> findFirstByFuncionarioIdAndStatusOrderByDataAberturaDesc(Integer funcionarioId, StatusCaixa status);

    boolean existsByFuncionarioIdAndStatus(Integer funcionarioId, StatusCaixa status);
}