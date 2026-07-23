package com.corleone.produto.mapper;

import com.corleone.categoria.entity.Categoria;
import com.corleone.fornecedor.entity.Fornecedor;
import com.corleone.produto.dto.ProdutoRequest;
import com.corleone.produto.dto.ProdutoResponse;
import com.corleone.produto.dto.ProdutoResumoResponse;
import com.corleone.produto.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProdutoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "promocoes", ignore = true)
    @Mapping(target = "ingredientes", ignore = true)
    @Mapping(target = "sabores", ignore = true)
    @Mapping(target = "tamanhos", ignore = true)

    @Mapping(target = "fornecedor", source = "fornecedor")
    @Mapping(target = "categoria", source = "categoria")

    @Mapping(target = "codigo", source = "request.codigo")
    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "precoCusto", source = "request.precoCusto")
    @Mapping(target = "precoVenda", source = "request.precoVenda")
    @Mapping(target = "estoqueMinimo", source = "request.estoqueMinimo")
    Produto toEntity(ProdutoRequest request, Fornecedor fornecedor, Categoria categoria);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fornecedorId", source = "fornecedor.id")
    @Mapping(target = "fornecedorNome", source = "fornecedor.forNome")
    @Mapping(target = "categoriaId", source = "categoria.id")
    @Mapping(target = "categoriaNome", source = "categoria.catNome")
    ProdutoResponse toResponse(Produto produto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "categoria", source = "categoria.catNome")
    @Mapping(target = "fornecedor", source = "fornecedor.forNome")
    ProdutoResumoResponse toResumoResponse(Produto produto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "promocoes", ignore = true)
    @Mapping(target = "ingredientes", ignore = true)
    @Mapping(target = "sabores", ignore = true)
    @Mapping(target = "tamanhos", ignore = true)

    @Mapping(target = "fornecedor", source = "fornecedor")
    @Mapping(target = "categoria", source = "categoria")

    @Mapping(target = "codigo", source = "request.codigo")
    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "precoCusto", source = "request.precoCusto")
    @Mapping(target = "precoVenda", source = "request.precoVenda")
    @Mapping(target = "estoqueMinimo", source = "request.estoqueMinimo")
    void updateEntity(@MappingTarget Produto produto, ProdutoRequest request, Fornecedor fornecedor, Categoria categoria);

}