package com.corleone.pedido.mapper;

import com.corleone.pedido.dto.HistoricoPedidoResponse;
import com.corleone.pedido.entity.HistoricoPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoricoPedidoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pedido", source = "pedido")
    @Mapping(target = "funcionario", source = "funcionario")
    @Mapping(target = "data", ignore = true)
    HistoricoPedido toEntity(HistoricoPedidoResponse response, com.corleone.pedido.entity.Pedido pedido, com.corleone.funcionario.entity.Funcionario funcionario);

    @Mapping(target = "pedidoId", source = "pedido.id")
    @Mapping(target = "funcionarioId", source = "funcionario.id")
    @Mapping(target = "funcionario", source = "funcionario.nome")
    HistoricoPedidoResponse toResponse(HistoricoPedido historico);
}
