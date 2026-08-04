package com.corleone.avaliacao.mapper;

import com.corleone.avaliacao.dto.AvaliacaoRequest;
import com.corleone.avaliacao.dto.AvaliacaoResponse;
import com.corleone.avaliacao.dto.AvaliacaoResumoResponse;
import com.corleone.avaliacao.entity.Avaliacao;
import com.corleone.cliente.entity.Cliente;
import com.corleone.pedido.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AvaliacaoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pedido", source = "pedido")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "dataCriacao", ignore = true)
    Avaliacao toEntity(AvaliacaoRequest request, Pedido pedido, Cliente cliente);

    @Mapping(target = "pedidoId", source = "pedido.id")
    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "cliente", source = "cliente.cliNome")
    AvaliacaoResponse toResponse(Avaliacao avaliacao);

    @Mapping(target = "cliente", source = "cliente.cliNome")
    AvaliacaoResumoResponse toResumoResponse(Avaliacao avaliacao);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pedido", source = "pedido")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "dataCriacao", ignore = true)
    void updateEntity(@MappingTarget Avaliacao avaliacao, AvaliacaoRequest request, Pedido pedido, Cliente cliente);

}