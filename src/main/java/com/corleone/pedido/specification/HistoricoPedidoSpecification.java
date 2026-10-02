package com.corleone.pedido.specification;

import com.corleone.pedido.dto.HistoricoPedidoFilter;
import com.corleone.pedido.entity.HistoricoPedido;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HistoricoPedidoSpecification {

    private HistoricoPedidoSpecification() {
    }

    public static Specification<HistoricoPedido> filtro(HistoricoPedidoFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getPedidoId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("pedido").get("id"), filter.getPedidoId())
                );
            }

            
        };
    }
}