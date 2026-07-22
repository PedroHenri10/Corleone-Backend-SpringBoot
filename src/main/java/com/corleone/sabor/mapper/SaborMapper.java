package com.corleone.sabor.mapper;

import com.corleone.sabor.dto.SaborRequest;
import com.corleone.sabor.dto.SaborResponse;
import com.corleone.sabor.dto.SaborResumoResponse;
import com.corleone.sabor.entity.Sabor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SaborMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descricao", source = "descricao")
    Sabor toEntity(SaborRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "ativo", source = "ativo")
    SaborResponse toResponse(Sabor sabor);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "ativo", source = "ativo")
    SaborResumoResponse toResumoResponse(Sabor sabor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descricao", source = "descricao")
    void updateEntity(@MappingTarget Sabor sabor, SaborRequest request);
}