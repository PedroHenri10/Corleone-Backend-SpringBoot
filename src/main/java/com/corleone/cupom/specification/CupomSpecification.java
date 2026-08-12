package com.corleone.cupom.specification;

import com.corleone.cupom.entity.Cupom;
import com.corleone.shared.enums.TipoCupom;
import org.springframework.data.jpa.domain.Specification;

public class CupomSpecification {
    public static Specification<Cupom> codigo(String codigo){
        return (root, query,cb) ->
                codigo == null || codigo.isBlank()
                        ? null : cb.like(cb.lower(root.get("codigo")),
                        "%" + codigo.toLowerCase() + "%");
    }

    public static Specification<Cupom> tipo(TipoCupom tipo){
        return ((root, query, cb) ->
                tipo == null ? null : cb.equal(root.get("tipo"), tipo));
    }

    
}
