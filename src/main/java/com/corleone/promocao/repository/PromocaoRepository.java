package com.corleone.promocao.repository;

import com.corleone.promocao.entity.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PromocaoRepository extends JpaRepository<Promocao, Integer>, JpaSpecificationExecutor<Promocao> {

    boolean existsByProdutoId(Integer produtoId);
}