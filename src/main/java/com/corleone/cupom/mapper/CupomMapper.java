package com.corleone.cupom.mapper;

import com.corleone.cupom.dto.CupomRequest;
import com.corleone.cupom.dto.CupomResponse;
import com.corleone.cupom.dto.CupomResumoResponse;
import com.corleone.cupom.entity.Cupom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CupomMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", constant = "true")
    @Mapping(target = "dataCriacao", ignore = true)
    Cupom toEntity(CupomRequest request);

    CupomResponse toResponse(Cupom cupom);

    CupomResumoResponse toResumoResponse(Cupom cupom);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    void updateEntity(@MappingTarget Cupom cupom, CupomRequest request);
}