package com.corleone.fornecedor.specification;

import com.corleone.fornecedor.entity.Fornecedor;
import org.springframework.data.jpa.domain.Specification;

public class FornecedorSpecification {
    private FornecedorSpecification() {
    }

    public static Specification<Fornecedor> nome(String nome) {

        return (root, query, cb) ->
                nome == null
                        ? null
                        : cb.like(
                        cb.lower(root.get("forNome")),
                        "%" + nome.toLowerCase() + "%"
                );
    }

    public static Specification<Fornecedor> cnpj(String cnpj) {

        return (root, query, cb) ->
                cnpj == null
                        ? null
                        : cb.equal(root.get("forCnpj"), cnpj);
    }

    public static Specification<Fornecedor> cidade(String cidade) {

        return (root, query, cb) ->
                cidade == null
                        ? null
                        : cb.like(
                        cb.lower(root.get("endereco").get("endCidade")),
                        "%" + cidade.toLowerCase() + "%"
                );
    }

    public static Specification<Fornecedor> ativo(Boolean ativo) {

        return (root, query, cb) ->
                ativo == null
                        ? null
                        : cb.equal(root.get("forAtivo"), ativo);
    }

    public static Specification<Fornecedor> somenteAtivos() {

        return (root, query, cb) ->
                cb.isTrue(root.get("forAtivo"));
    }

}