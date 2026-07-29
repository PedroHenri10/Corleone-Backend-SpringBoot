package com.corleone.entrega.specification;

import com.corleone.entrega.dto.EntregaFilter;
import com.corleone.entrega.entity.Entrega;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

public final class EntregaSpecification {

    private EntregaSpecification() {
    }

    public static Specification<Entrega> filtro(EntregaFilter filter) {

        return Specification
                .where(pedido(filter.getPedidoId()))
                .and(entregador(filter.getEntregadorId()))
                .and(status(filter.getStatus()));

    }

    private static Specification<Entrega> pedido(Integer pedidoId) {

        return (root, query, builder) ->

                ObjectUtils.isEmpty(pedidoId)
                        ? null
                        : builder.equal(root.get("pedido").get("id"), pedidoId);

    }

    private static Specification<Entrega> entregador(Integer entregadorId) {

        return (root, query, builder) ->

                ObjectUtils.isEmpty(entregadorId)
                        ? null
                        : builder.equal(root.get("entregador").get("id"), entregadorId);

    }

    private static Specification<Entrega> status(com.corleone.shared.enums.StatusEntrega status) {

        return (root, query, builder) ->

                ObjectUtils.isEmpty(status)
                        ? null
                        : builder.equal(root.get("status"), status);

    }

}
