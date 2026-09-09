package com.corleone.caixa.specification;

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

    public static Specification<Caixa> dataInicial(
            java.time.LocalDate dataInicial) {

        return (root, query, cb) ->
                dataInicial == null
                        ? null
                        : cb.greaterThanOrEqualTo(
                        root.get("dataAbertura"),
                        dataInicial.atStartOfDay()
                );
    }

    
}
