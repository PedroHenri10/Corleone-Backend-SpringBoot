package com.corleone.ingrediente.specification;

import com.corleone.ingrediente.dto.IngredienteFilter;
import com.corleone.ingrediente.entity.Ingrediente;
import org.springframework.data.jpa.domain.Specification;

public class IngredienteSpecification {

    private IngredienteSpecification() {
    }

    public static Specification<Ingrediente> filtrar(IngredienteFilter filtro) {

        return Specification
                .where(nomeContem(filtro.getNome()))
                .and(unidadeIgual(filtro.getUnidade()))
                .and(ativoIgual(filtro.getAtivo()));
    }

    private static Specification<Ingrediente> nomeContem(String nome) {

        return (root, query, cb) ->
                nome == null || nome.isBlank()
                        ? null
                        : cb.like(
                        cb.lower(root.get("nome")),
                        "%" + nome.toLowerCase() + "%"
                );
    }

    private static Specification<Ingrediente> unidadeIgual(String unidade) {

        return (root, query, cb) ->
                unidade == null || unidade.isBlank()
                        ? null
                        : cb.equal(
                        cb.lower(root.get("unidade")),
                        unidade.toLowerCase()
                );
    }

    private static Specification<Ingrediente> ativoIgual(Boolean ativo) {

        return (root, query, cb) ->
                ativo == null
                        ? null
                        : cb.equal(root.get("ativo"), ativo);
    }

}