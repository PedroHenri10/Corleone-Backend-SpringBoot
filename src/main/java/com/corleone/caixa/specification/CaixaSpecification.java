package com.corleone.caixa.specification;

import com.corleone.caixa.dto.CaixaFilter;
import com.corleone.caixa.entity.Caixa;
import com.corleone.shared.enums.StatusCaixa;
import org.springframework.data.jpa.domain.Specification;

public class CaixaSpecification {

    public static Specification<Caixa> funcionarioId(Integer funcionarioId) {
        return (root, query, cb) ->
                funcionarioId == null
                        ? null
                        : cb.equal(
                        root.get("funcionario").get("id"),
                        funcionarioId
                );
    }

    public static Specification<Caixa> status(StatusCaixa status) {
        return (root, query, cb) ->
                status == null
                        ? null
                        : cb.equal(root.get("status"), status);
    }

    public static Specification<Caixa> dataInicial(java.time.LocalDate dataInicial) {

        return (root, query, cb) ->
                dataInicial == null
                        ? null
                        : cb.greaterThanOrEqualTo(
                        root.get("dataAbertura"),
                        dataInicial.atStartOfDay()
                );
    }

    public static Specification<Caixa> dataFinal(java.time.LocalDate dataFinal) {

        return (root, query, cb) ->
                dataFinal == null
                        ? null
                        : cb.lessThan(
                        root.get("dataAbertura"),
                        dataFinal.plusDays(1).atStartOfDay()
                );
    }

    public static Specification<Caixa> filtro(CaixaFilter filter) {

        if (filter == null) {
            return null;
        }

        return Specification
                .where(funcionarioId(filter.getFuncionarioId()))
                .and(status(filter.getStatus()))
                .and(dataInicial(filter.getDataInicial()))
                .and(dataFinal(filter.getDataFinal()));
    }
}
