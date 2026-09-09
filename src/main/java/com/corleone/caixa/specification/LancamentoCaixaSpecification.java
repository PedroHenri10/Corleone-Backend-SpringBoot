package com.corleone.caixa.specification;

import com.corleone.caixa.entity.LancamentoCaixa;
import org.springframework.data.jpa.domain.Specification;

public class LancamentoCaixaSpecification {
    public static Specification<LancamentoCaixa> caixaId(Integer caixaId) {

        return (root, query, cb) ->
                caixaId == null
                        ? null
                        : cb.equal(
                        root.get("caixa").get("id"),
                        caixaId
                );
    }

    public static Specification<LancamentoCaixa> funcionarioId(Integer funcionarioId) {

        return (root, query, cb) ->
                funcionarioId == null
                        ? null
                        : cb.equal(
                        root.get("funcionario").get("id"),
                        funcionarioId
                );
    }

}
