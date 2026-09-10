package com.corleone.caixa.specification;

import com.corleone.caixa.entity.LancamentoCaixa;
import com.corleone.shared.enums.TipoLancamentoCaixa;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

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

    public static Specification<LancamentoCaixa> pagamentoId(Integer pagamentoId) {

        return (root, query, cb) ->
                pagamentoId == null ? null : cb.equal(root.get("pagamento").get("id"), pagamentoId);
    }

    public static Specification<LancamentoCaixa> tipo(
            TipoLancamentoCaixa tipo) {

        return (root, query, cb) ->
                tipo == null ? null : cb.equal(root.get("tipo"), tipo);
    }

    public static Specification<LancamentoCaixa> dataInicial(LocalDate dataInicial) {

        return (root, query, cb) ->
                dataInicial == null ? null : cb.greaterThanOrEqualTo(root.get("data"), dataInicial.atStartOfDay());
    }

    public static Specification<LancamentoCaixa> dataFinal(LocalDate dataFinal) {

        return (root, query, cb) ->
                dataFinal == null ? null : cb.lessThan(root.get("data"), dataFinal.plusDays(1).atStartOfDay());
    }

}
