package com.corleone.pagamento.specification;

import com.corleone.pagamento.dto.PagamentoFilter;
import com.corleone.pagamento.entity.Pagamento;
import org.springframework.data.jpa.domain.Specification;

public class PagamentoSpecification {

    public static Specification<Pagamento> nome(String nome) {
        return (root, query, cb) ->
                nome == null || nome.isBlank() ? null : cb.like(cb.lower(root.get("nome")),
                        "%" + nome.toLowerCase() + "%"
                );
    }

    public static Specification<Pagamento> ativo(Boolean ativo) {
        return (root, query, cb) ->
                ativo == null ? null : cb.equal(root.get("ativo"), ativo);
    }

    public static Specification<Pagamento> somenteAtivos() {
        return (root, query, cb) -> cb.isTrue(root.get("ativo"));
    }

    public static Specification<Pagamento> filtro(PagamentoFilter filter) {

        if (filter == null) {
            return null;
        }

        return Specification.where(nome(filter.getNome())).and(ativo(filter.getAtivo()));
    }
}
