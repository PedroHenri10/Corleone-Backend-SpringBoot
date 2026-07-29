package com.corleone.entrega.mapper;

import com.corleone.entrega.dto.AtualizarStatusEntregaRequest;
import com.corleone.entrega.dto.EntregaRequest;
import com.corleone.entrega.dto.EntregaResponse;
import com.corleone.entrega.dto.EntregaResumoResponse;
import com.corleone.entrega.entity.Entrega;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EntregaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pedido", ignore = true)
    @Mapping(target = "entregador", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "dataSaida", ignore = true)
    @Mapping(target = "dataEntrega", ignore = true)
    Entrega toEntity(EntregaRequest request);

    @Mapping(target = "pedidoId", source = "pedido.id")
    @Mapping(target = "entregadorId", source = "entregador.id")
    @Mapping(target = "entregador", source = "entregador.nome")
    @Mapping(target = "enderecoId", source = "endereco.id")
    EntregaResponse toResponse(Entrega entrega);

    @Mapping(target = "pedidoId", source = "pedido.id")
    @Mapping(target = "entregador", source = "entregador.nome")
    EntregaResumoResponse toResumoResponse(Entrega entrega);

    void updateEntity(AtualizarStatusEntregaRequest request, @MappingTarget Entrega entrega);

}