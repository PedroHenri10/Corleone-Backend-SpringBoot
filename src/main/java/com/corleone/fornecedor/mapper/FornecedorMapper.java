package com.corleone.fornecedor.mapper;

import com.corleone.endereco.entity.Endereco;
import com.corleone.fornecedor.dto.FornecedorRequest;
import com.corleone.fornecedor.dto.FornecedorResponse;
import com.corleone.fornecedor.dto.FornecedorResumoResponse;
import com.corleone.fornecedor.entity.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FornecedorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "forAtivo", constant = "true")
    @Mapping(target = "forDtCriacao", ignore = true)
    @Mapping(target = "forDtAtualizacao", ignore = true)

    @Mapping(target = "forNome", source = "request.nome")
    @Mapping(target = "forNomeFantasia", source = "request.nomeFantasia")
    @Mapping(target = "forCnpj", source = "request.cnpj")
    @Mapping(target = "forTelefone", source = "request.telefone")
    @Mapping(target = "forEmail", source = "request.email")
    @Mapping(target = "forContatoResponsavel", source = "request.contatoResponsavel")
    @Mapping(target = "endereco", source = "endereco")
    Fornecedor toEntity(FornecedorRequest request, Endereco endereco);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "forNome")
    @Mapping(target = "nomeFantasia", source = "forNomeFantasia")
    @Mapping(target = "cnpj", source = "forCnpj")
    @Mapping(target = "telefone", source = "forTelefone")
    @Mapping(target = "email", source = "forEmail")
    @Mapping(target = "contatoResponsavel", source = "forContatoResponsavel")
    @Mapping(target = "ativo", source = "forAtivo")
    @Mapping(target = "dataCriacao", source = "forDtCriacao")
    @Mapping(target = "dataAtualizacao", source = "forDtAtualizacao")
    @Mapping(target = "enderecoId", source = "endereco.id")
    @Mapping(target = "cidade", source = "endereco.endCidade")
    @Mapping(target = "estado", source = "endereco.endEstado")
    FornecedorResponse toResponse(Fornecedor fornecedor);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "forNome")
    @Mapping(target = "cnpj", source = "forCnpj")
    @Mapping(target = "telefone", source = "forTelefone")
    @Mapping(target = "ativo", source = "forAtivo")
    FornecedorResumoResponse toResumoResponse(Fornecedor fornecedor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "forAtivo", ignore = true)
    @Mapping(target = "forDtCriacao", ignore = true)
    @Mapping(target = "forDtAtualizacao", ignore = true)

    @Mapping(target = "forNome", source = "request.nome")
    @Mapping(target = "forNomeFantasia", source = "request.nomeFantasia")
    @Mapping(target = "forCnpj", source = "request.cnpj")
    @Mapping(target = "forTelefone", source = "request.telefone")
    @Mapping(target = "forEmail", source = "request.email")
    @Mapping(target = "forContatoResponsavel", source = "request.contatoResponsavel")
    @Mapping(target = "endereco", source = "endereco")
    void updateEntity(@MappingTarget Fornecedor fornecedor, FornecedorRequest request, Endereco endereco);
}