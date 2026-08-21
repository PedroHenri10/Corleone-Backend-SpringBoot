package com.corleone.promocao.specification;

import com.corleone.promocao.dto.PromocaoFilter;
import com.corleone.promocao.entity.Promocao;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class PromocaoSpecification {

    public static Specification<Promocao> produtoId(Integer produtoId) {
        return (root, query, cb) ->
                produtoId == null ? null : cb.equal(root.get("produto").get("id"), produtoId);
    }

    public static Specification<Promocao> nome(String nome) {
        return (root, query, cb) ->
                nome == null || nome.isBlank() ? null : cb.like(cb.lower(root.get("nome")),
                        "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Promocao> ativa(Boolean ativa) {
        return (root, query, cb) ->
                ativa == null ? null : cb.equal(root.get("ativa"), ativa);
    }

    public static Specification<Promocao> dataInicio(LocalDateTime dataInicio) {

        return (root, query, cb) ->
                dataInicio == null ? null : cb.greaterThanOrEqualTo(root.get("dataInicio"), dataInicio);
    }

    
}