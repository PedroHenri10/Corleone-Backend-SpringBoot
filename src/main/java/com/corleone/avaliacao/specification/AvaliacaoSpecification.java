package com.corleone.avaliacao.specification;

import com.corleone.avaliacao.dto.AvaliacaoFilter;
import com.corleone.avaliacao.entity.Avaliacao;
import org.springframework.data.jpa.domain.Specification;

public class AvaliacaoSpecification {

    public static Specification<Avaliacao> cliente(Integer clienteId) {

        return (root, query, cb) ->
                clienteId == null
                        ? null
                        : cb.equal(root.get("cliente").get("id"), clienteId);
    }

    public static Specification<Avaliacao> pedido(Integer pedidoId) {

        return (root, query, cb) ->
                pedidoId == null
                        ? null
                        : cb.equal(root.get("pedido").get("id"), pedidoId);
    }

    public static Specification<Avaliacao> nota(Integer nota) {

        return (root, query, cb) ->
                nota == null
                        ? null
                        : cb.equal(root.get("nota"), nota);
    }

    public static Specification<Avaliacao> dataInicial(java.time.LocalDate dataInicial) {

        return (root, query, cb) ->
                dataInicial == null
                        ? null
                        : cb.greaterThanOrEqualTo(
                        root.get("dataCriacao"),
                        dataInicial.atStartOfDay());
    }

    public static Specification<Avaliacao> dataFinal(java.time.LocalDate dataFinal) {

        return (root, query, cb) ->
                dataFinal == null
                        ? null
                        : cb.lessThanOrEqualTo(
                        root.get("dataCriacao"),
                        dataFinal.atTime(23, 59, 59));
    }

    

}