package com.corleone.pedido.specification;

import com.corleone.pedido.dto.ItemPedidoFilter;
import com.corleone.pedido.entity.ItemPedido;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoSpecification {

    private ItemPedidoSpecification() {
    }

    public static Specification<ItemPedido> filtro(ItemPedidoFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getPedidoId() != null) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("pedido").get("id"),
                                filter.getPedidoId()
                        )
                );
            }

            if (filter.getProdutoId() != null) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("produto").get("id"),
                                filter.getProdutoId()
                        )
                );
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}