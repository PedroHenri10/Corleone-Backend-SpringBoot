package com.corleone.produto.repository;

import com.corleone.produto.entity.ProdutoTamanho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoTamanhoRepository extends JpaRepository<ProdutoTamanho, Integer> {

    List<ProdutoTamanho> findByProdutoId(Integer produtoId);

    void deleteByProdutoId(Integer produtoId);
}