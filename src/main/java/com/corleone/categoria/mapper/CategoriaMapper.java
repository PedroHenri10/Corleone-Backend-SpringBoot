package com.corleone.categoria.mapper;

import com.corleone.categoria.dto.CategoriaRequest;
import com.corleone.categoria.dto.CategoriaResponse;
import com.corleone.categoria.dto.CategoriaResumoResponse;
import com.corleone.categoria.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoriaMapper {

    @Mapping(target = "catNome", source = "nome")
    @Mapping(target = "catDescricao", source = "descricao")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "catAtivo", ignore = true)
    @Mapping(target = "catDtCriacao", ignore = true)
    @Mapping(target = "catDtAtualizacao", ignore = true)
    Categoria toEntity(CategoriaRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "catNome")
    @Mapping(target = "descricao", source = "catDescricao")
    @Mapping(target = "ativo", source = "catAtivo")
    @Mapping(target = "dtCriacao", source = "catDtCriacao")
    @Mapping(target = "dtAtualizacao", source = "catDtAtualizacao")
    CategoriaResponse toResponse(Categoria categoria);

    @Mapping(target = "catNome", source = "nome")
    @Mapping(target = "catDescricao", source = "descricao")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "catAtivo", ignore = true)
    @Mapping(target = "catDtCriacao", ignore = true)
    @Mapping(target = "catDtAtualizacao", ignore = true)
    void updateEntity(@MappingTarget Categoria categoria, CategoriaRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "catNome")
    @Mapping(target = "descricao", source = "catDescricao")
    @Mapping(target = "ativo", source = "catAtivo")
    CategoriaResumoResponse toResumoResponse(Categoria categoria);
}
