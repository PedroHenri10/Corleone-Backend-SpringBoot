package com.corleone.pedido.mapper;

import com.corleone.funcionario.entity.Funcionario;
import com.corleone.pedido.dto.HistoricoPedidoRequest;
import com.corleone.pedido.dto.HistoricoPedidoResponse;
import com.corleone.pedido.entity.HistoricoPedido;
import com.corleone.pedido.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoricoPedidoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pedido", source = "pedido")
    @Mapping(target = "funcionario", source = "funcionario")
    @Mapping(target = "statusAnterior", source = "statusAnterior")
    @Mapping(target = "statusNovo", source = "statusNovo")
    @Mapping(target = "data", ignore = true)
    HistoricoPedido toEntity(HistoricoPedidoRequest request, Pedido pedido, Funcionario funcionario, String statusAnterior,
            String statusNovo);

    @Mapping(target = "pedidoId", source = "pedido.id")
    @Mapping(target = "funcionarioId", source = "funcionario.id")
    @Mapping(target = "funcionario", source = "funcionario.nome")
    HistoricoPedidoResponse toResponse(HistoricoPedido historico);

}
