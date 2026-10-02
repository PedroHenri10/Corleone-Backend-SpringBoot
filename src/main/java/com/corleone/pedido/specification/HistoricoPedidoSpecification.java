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

            if (filter.getFuncionarioId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("funcionario").get("id"), filter.getFuncionarioId())
                );
            }

            if (filter.getStatusAnterior() != null && !filter.getStatusAnterior().isBlank()) {
                predicates.add(criteriaBuilder.equal(root.get("statusAnterior"),
                                filter.getStatusAnterior()));
            }

            if (filter.getStatusNovo() != null && !filter.getStatusNovo().isBlank()) {
                predicates.add(criteriaBuilder.equal(root.get("statusNovo"),
                                filter.getStatusNovo()));
            }

            if (filter.getDataInicial() != null) {LocalDateTime dataInicial = filter.getDataInicial().atStartOfDay();

                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("data"),
                                dataInicial));
            }

            
        };
    }
}