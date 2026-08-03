package com.corleone.mesa.specification;

import com.corleone.mesa.dto.MesaFilter;
import com.corleone.mesa.entity.Mesa;
import com.corleone.shared.enums.StatusMesa;
import org.springframework.data.jpa.domain.Specification;

public class MesaSpecification {

    public static Specification<Mesa> filtro(MesaFilter filter) {

        return Specification.where(numero(filter.getNumero()))
                .and(capacidade(filter.getCapacidade()))
                .and(status(filter.getStatus()))
                .and(ativo(filter.getAtivo()));
    }

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

    public static Specification<Mesa> capacidade(Integer capacidade) {

        return (root, query, cb) ->
                capacidade == null
                        ? null
                        : cb.equal(root.get("capacidade"), capacidade);
    }

    public static Specification<Mesa> status(StatusMesa status) {

        return (root, query, cb) ->
                status == null
                        ? null
                        : cb.equal(root.get("status"), status);
    }

}
