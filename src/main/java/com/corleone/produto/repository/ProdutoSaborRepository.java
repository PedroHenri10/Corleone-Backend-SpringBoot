package com.corleone.produto.repository;

import com.corleone.produto.entity.ProdutoSabor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoSaborRepository extends JpaRepository<ProdutoSabor, Integer> {

    List<ProdutoSabor> findByProdutoId(Integer produtoId);

    void deleteByProdutoId(Integer produtoId);
}