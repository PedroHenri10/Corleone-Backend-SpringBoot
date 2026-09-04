package com.corleone.caixa.repository;

import com.corleone.caixa.entity.LancamentoCaixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LancamentoCaixaRepository extends JpaRepository<LancamentoCaixa, Integer>, JpaSpecificationExecutor<LancamentoCaixa> {

    List<LancamentoCaixa> findByCaixaId(Integer caixaId);

    List<LancamentoCaixa> findByPedidoId(Integer pedidoId);
}