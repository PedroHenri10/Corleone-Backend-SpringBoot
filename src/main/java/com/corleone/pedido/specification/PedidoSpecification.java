package com.corleone.pedido.specification;

import com.corleone.pedido.dto.PedidoFilter;
import com.corleone.pedido.entity.Pedido;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoSpecification {

    private PedidoSpecification() {
    }

    public static Specification<Pedido> filtro(PedidoFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getClienteId() != null) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("cliente").get("id"),
                                filter.getClienteId()
                        )
                );
            }

            if (filter.getFuncionarioId() != null) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("funcionario").get("id"),
                                filter.getFuncionarioId()
                        )
                );
            }

            if (filter.getMesaId() != null) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("mesa").get("id"),
                                filter.getMesaId()
                        )
                );
            }

            if (filter.getTipo() != null) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("tipo"),
                                filter.getTipo()
                        )
                );
            }

            if (filter.getStatus() != null) {
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("status"),
                                filter.getStatus()
                        )
                );
            }

            

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}