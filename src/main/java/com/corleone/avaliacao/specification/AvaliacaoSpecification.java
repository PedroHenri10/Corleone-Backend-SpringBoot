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

}