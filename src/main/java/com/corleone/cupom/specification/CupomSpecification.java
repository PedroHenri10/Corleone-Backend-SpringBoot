package com.corleone.cupom.specification;

import com.corleone.cupom.dto.CupomFilter;
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
        return (root, query, cb) ->
                tipo == null ? null : cb.equal(root.get("tipo"), tipo);
    }

    public static Specification<Cupom> ativo(Boolean ativo){
        return (root, query,cb) ->
                ativo == null ? null : cb.equal(root.get("ativo"), ativo);
    }

    public static Specification<Cupom> dataInicio(java.time.LocalDate dataInicio){
        return (root, query,cb) ->
                dataInicio == null ? null : cb.greaterThanOrEqualTo(root.get("dataInicio"), dataInicio.atStartOfDay());
    }

    public static Specification<Cupom> dataFim(java.time.LocalDate dataFim){
        return (root, query, cb) ->
                dataFim == null ? null : cb.lessThanOrEqualTo(root.get("dataFim"), dataFim.atTime(23,59,59));
    }

    public static Specification<Cupom> filtro(CupomFilter filter){

        if(filter == null){
            return null;
        }

        return Specification.where(codigo(filter.getCodigo()))
                .and(tipo(filter.getTipo()))
                .and(ativo(filter.getAtivo()))
                .and(dataInicio(filter.getDataInicio()))
                .and(dataFim(filter.getDataFim()));
    }

   
}
