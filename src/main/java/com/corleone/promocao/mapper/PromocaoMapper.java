package com.corleone.promocao.mapper;

import com.corleone.promocao.dto.PromocaoRequest;
import com.corleone.promocao.dto.PromocaoResponse;
import com.corleone.promocao.dto.PromocaoResumoResponse;
import com.corleone.promocao.entity.Promocao;
import com.corleone.produto.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PromocaoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produto", source = "produto")
    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "percentual", source = "request.percentual")
    @Mapping(target = "dataInicio", source = "request.dataInicio")
    @Mapping(target = "dataFim", source = "request.dataFim")
    @Mapping(target = "ativa", source = "request.ativa")
    Promocao toEntity(PromocaoRequest request, Produto produto);

    @Mapping(target = "produtoId", source = "produto.id")
    @Mapping(target = "produto", source = "produto.nome")
    PromocaoResponse toResponse(Promocao promocao);

    @Mapping(target = "produto", source = "produto.nome")
    PromocaoResumoResponse toResumoResponse(Promocao promocao);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produto", source = "produto")
    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "percentual", source = "request.percentual")
    @Mapping(target = "dataInicio", source = "request.dataInicio")
    @Mapping(target = "dataFim", source = "request.dataFim")
    @Mapping(target = "ativa", source = "request.ativa")
    void updateEntity(@MappingTarget Promocao promocao, PromocaoRequest request, Produto produto);
}