package com.corleone.produto.repository;

import com.corleone.produto.entity.ProdutoIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoIngredienteRepository extends JpaRepository<ProdutoIngrediente, Integer> {

    List<ProdutoIngrediente> findByProdutoId(Integer produtoId);

    void deleteByProdutoId(Integer produtoId);
}
