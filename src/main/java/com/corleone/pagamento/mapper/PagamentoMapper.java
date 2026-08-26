package com.corleone.pagamento.mapper;

import com.corleone.pagamento.dto.PagamentoRequest;
import com.corleone.pagamento.dto.PagamentoResponse;
import com.corleone.pagamento.dto.PagamentoResumoResponse;
import com.corleone.pagamento.entity.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PagamentoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", constant = "true")
    Pagamento toEntity(PagamentoRequest request);

    PagamentoResponse toResponse(Pagamento pagamento);

    
}