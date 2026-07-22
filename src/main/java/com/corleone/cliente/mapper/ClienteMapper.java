package com.corleone.cliente.mapper;

import com.corleone.cliente.dto.*;
import com.corleone.cliente.entity.Cliente;
import com.corleone.endereco.entity.Endereco;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)

    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "telefone1", source = "request.telefone1")
    @Mapping(target = "telefone2", source = "request.telefone2")
    @Mapping(target = "email", source = "request.email")
    @Mapping(target = "status", source = "request.status")
    @Mapping(target = "endereco", source = "endereco")
    Cliente toEntity(ClienteRequest request, Endereco endereco);

    @Mapping(target = "enderecoId", source = "endereco.id")
    @Mapping(target = "cidade", source = "endereco.endCidade")
    @Mapping(target = "estado", source = "endereco.endEstado")
    ClienteResponse toResponse(Cliente cliente);

    @Mapping(target = "cidade", source = "endereco.endCidade")
    ClienteResumoResponse toResumoResponse(Cliente cliente);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)

    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "telefone1", source = "request.telefone1")
    @Mapping(target = "telefone2", source = "request.telefone2")
    @Mapping(target = "email", source = "request.email")
    @Mapping(target = "status", source = "request.status")
    @Mapping(target = "endereco", source = "endereco")
    void updateEntity(@MappingTarget Cliente cliente, ClienteRequest request, Endereco endereco);

}