package com.corleone.pagamento.specification;

import com.corleone.pagamento.entity.Pagamento;
import org.springframework.data.jpa.domain.Specification;

public class PagamentoSpecification {

    public static Specification<Pagamento> nome(String nome) {
        return (root, query, cb) ->
                nome == null || nome.isBlank() ? null : cb.like(cb.lower(root.get("nome")),
                        "%" + nome.toLowerCase() + "%"
                );
    }


}
