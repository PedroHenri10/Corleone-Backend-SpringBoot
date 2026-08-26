package com.corleone.pagamento.repository;

import com.corleone.pagamento.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>, JpaSpecificationExecutor<Pagamento> {

    boolean existsByNomeIgnoreCase(String nome);
}