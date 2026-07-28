package com.corleone.estoque.specification;

import com.corleone.estoque.dto.MovimentoIngredienteFilter;
import com.corleone.estoque.entity.MovimentoIngrediente;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MovimentoIngredienteSpecification {

    private MovimentoIngredienteSpecification() {
    }

    public static Specification<MovimentoIngrediente> filtrar(MovimentoIngredienteFilter filter) {

        return (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (filter.getIngredienteId() != null) {
                predicates.add(builder.equal(
                        root.get("ingrediente").get("id"),
                        filter.getIngredienteId()));
            }

            if (filter.getFuncionarioId() != null) {
                predicates.add(builder.equal(
                        root.get("funcionario").get("id"),
                        filter.getFuncionarioId()));
            }

            if (filter.getTipo() != null) {
                predicates.add(builder.equal(
                        root.get("tipo"),
                        filter.getTipo()));
            }

            if (filter.getDocumento() != null &&
                    !filter.getDocumento().isBlank()) {

                predicates.add(builder.like(
                        builder.lower(root.get("documento")),
                        "%" + filter.getDocumento().toLowerCase() + "%"
                ));
            }

            if (filter.getDataInicial() != null) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get("dataMovimentacao"),
                        filter.getDataInicial()));
            }

            if (filter.getDataFinal() != null) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get("dataMovimentacao"),
                        filter.getDataFinal()));
            }

            query.orderBy(builder.desc(root.get("dataMovimentacao")));

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}