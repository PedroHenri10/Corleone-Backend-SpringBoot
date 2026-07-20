package com.corleone.endereco.mapper;

import com.corleone.endereco.dto.EnderecoRequest;
import com.corleone.endereco.dto.EnderecoResponse;
import com.corleone.endereco.dto.EnderecoResumoResponse;
import com.corleone.endereco.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnderecoMapper {

    @Mapping(target = "id", ignore = true)

    @Mapping(target = "endLogradouro", source = "logradouro")
    @Mapping(target = "endNumero", source = "numero")
    @Mapping(target = "endComplemento", source = "complemento")
    @Mapping(target = "endBairro", source = "bairro")
    @Mapping(target = "endCidade", source = "cidade")
    @Mapping(target = "endEstado", source = "estado")
    Endereco toEntity(EnderecoRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "logradouro", source = "endLogradouro")
    @Mapping(target = "numero", source = "endNumero")
    @Mapping(target = "complemento", source = "endComplemento")
    @Mapping(target = "bairro", source = "endBairro")
    @Mapping(target = "cidade", source = "endCidade")
    @Mapping(target = "estado", source = "endEstado")
    EnderecoResponse toResponse(Endereco endereco);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "logradouro", source = "endLogradouro")
    @Mapping(target = "numero", source = "endNumero")
    @Mapping(target = "bairro", source = "endBairro")
    @Mapping(target = "cidade", source = "endCidade")
    @Mapping(target = "estado", source = "endEstado")
    EnderecoResumoResponse toResumoResponse(Endereco endereco);

    @Mapping(target = "id", ignore = true)

    @Mapping(target = "endLogradouro", source = "logradouro")
    @Mapping(target = "endNumero", source = "numero")
    @Mapping(target = "endComplemento", source = "complemento")
    @Mapping(target = "endBairro", source = "bairro")
    @Mapping(target = "endCidade", source = "cidade")
    @Mapping(target = "endEstado", source = "estado")
    void updateEntity(@MappingTarget Endereco endereco, EnderecoRequest request);
}