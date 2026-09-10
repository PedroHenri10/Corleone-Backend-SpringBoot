package com.corleone.caixa.specification;

import com.corleone.caixa.entity.LancamentoCaixa;
import org.springframework.data.jpa.domain.Specification;

public class LancamentoCaixaSpecification {
    public static Specification<LancamentoCaixa> caixaId(Integer caixaId) {

        return (root, query, cb) ->
                caixaId == null ? null : cb.equal(root.get("caixa").get("id"), caixaId);
    }

    public static Specification<LancamentoCaixa> funcionarioId(Integer funcionarioId) {

        return (root, query, cb) ->
                funcionarioId == null ? null : cb.equal(root.get("funcionario").get("id"), funcionarioId);
    }

    public static Specification<LancamentoCaixa> pedidoId(Integer pedidoId) {

        return (root, query, cb) ->
                pedidoId == null ? null : cb.equal(root.get("pedido").get("id"), pedidoId);
    }
}
