package com.corleone.caixa.specification;

import com.corleone.caixa.entity.Caixa;
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

}
