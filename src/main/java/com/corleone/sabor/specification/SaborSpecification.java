package com.corleone.sabor.specification;

import com.corleone.sabor.entity.Sabor;
import org.springframework.data.jpa.domain.Specification;

public class SaborSpecification {

    public static Specification<Sabor> nome(String nome) {

        return (root, query, cb) -> {

            if (nome == null || nome.isBlank()) {
                return null;
            }

            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    public static Specification<Sabor> ativo(Boolean ativo) {

        return (root, query, cb) -> {

            if (ativo == null) {
                return null;
            }

            return cb.equal(root.get("ativo"), ativo);
        };
    }

    public static Specification<Sabor> somenteAtivos() {
        return (root, query, cb) ->
                cb.isTrue(root.get("ativo"));
    }
}