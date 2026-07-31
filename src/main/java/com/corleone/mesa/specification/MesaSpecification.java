package com.corleone.mesa.specification;

import com.corleone.mesa.entity.Mesa;
import org.springframework.data.jpa.domain.Specification;

public class MesaSpecification {
    public static Specification<Mesa> numero(Integer numero){

        return (root, query, cb) -> numero == null
                ? null
                : cb.equal(root.get("numero"), numero);
    }

    
}
