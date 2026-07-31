package com.corleone.mesa.specification;

import com.corleone.mesa.entity.Mesa;
import org.springframework.data.jpa.domain.Specification;

public class MesaSpecification {
    public static Specification<Mesa> numero(Integer numero){

        return (root, query, cb) -> numero == null
                ? null
                : cb.equal(root.get("numero"), numero);
    }

    public static Specification<Mesa> ativo(Boolean ativo) {

        return (root, query, cb) ->
                ativo == null
                        ? null
                        : cb.equal(root.get("ativo"), ativo);
    }

    public static Specification<Mesa> somenteAtivos(){
        return ((root, query, cb) -> cb.isTrue(root.get("ativo")));
    }
}
