package com.corleone.produto.specification;

import com.corleone.produto.dto.ProdutoFilter;
import com.corleone.produto.entity.Produto;
import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecification {

    private ProdutoSpecification() {
    }

    public static Specification<Produto> filtrar(ProdutoFilter filtro) {

        return Specification.where(codigo(filtro.getCodigo()))
                .and(nome(filtro.getNome()))
                .and(categoria(filtro.getCategoriaId()))
                .and(fornecedor(filtro.getFornecedorId()))
                .and(ativo(filtro.getAtivo()));

    }

    public static Specification<Produto> codigo(String codigo) {

        return (root, query, cb) ->

                codigo == null || codigo.isBlank()
                        ? null
                        : cb.like(
                        cb.lower(root.get("codigo")),
                        "%" + codigo.toLowerCase() + "%"
                );

    }

    public static Specification<Produto> nome(String nome) {

        return (root, query, cb) ->

                nome == null || nome.isBlank()
                        ? null
                        : cb.like(
                        cb.lower(root.get("nome")),
                        "%" + nome.toLowerCase() + "%"
                );

    }

    public static Specification<Produto> categoria(Integer categoriaId) {

        return (root, query, cb) ->

                categoriaId == null
                        ? null
                        : cb.equal(
                        root.get("categoria").get("id"),
                        categoriaId
                );

    }

    public static Specification<Produto> fornecedor(Integer fornecedorId) {

        return (root, query, cb) ->

                fornecedorId == null
                        ? null
                        : cb.equal(
                        root.get("fornecedor").get("id"),
                        fornecedorId
                );

    }

    public static Specification<Produto> ativo(Boolean ativo) {

        return (root, query, cb) ->

                ativo == null
                        ? null
                        : cb.equal(root.get("ativo"), ativo);

    }

}
