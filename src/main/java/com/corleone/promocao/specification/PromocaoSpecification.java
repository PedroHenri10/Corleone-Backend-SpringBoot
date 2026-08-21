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


}