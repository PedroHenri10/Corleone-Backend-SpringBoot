package com.corleone.ingrediente.mapper;

import com.corleone.ingrediente.dto.*;
import com.corleone.ingrediente.entity.Ingrediente;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IngredienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "unidade", source = "request.unidade")
    @Mapping(target = "custoUnitario", source = "request.custoUnitario")
    @Mapping(target = "estoqueMinimo", source = "request.estoqueMinimo")
    Ingrediente toEntity(IngredienteRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "unidade", source = "unidade")
    @Mapping(target = "custoUnitario", source = "custoUnitario")
    @Mapping(target = "estoqueMinimo", source = "estoqueMinimo")
    @Mapping(target = "ativo", source = "ativo")
    @Mapping(target = "dataCriacao", source = "dataCriacao")
    @Mapping(target = "dataAtualizacao", source = "dataAtualizacao")
    IngredienteResponse toResponse(Ingrediente ingrediente);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "unidade", source = "unidade")
    @Mapping(target = "ativo", source = "ativo")
    IngredienteResumoResponse toResumoResponse(Ingrediente ingrediente);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "unidade", source = "request.unidade")
    @Mapping(target = "custoUnitario", source = "request.custoUnitario")
    @Mapping(target = "estoqueMinimo", source = "request.estoqueMinimo")
    void updateEntity(@MappingTarget Ingrediente ingrediente, IngredienteRequest request);

}