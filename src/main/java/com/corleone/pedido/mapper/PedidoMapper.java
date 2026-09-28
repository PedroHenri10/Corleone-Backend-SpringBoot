package com.corleone.pedido.mapper;

import com.corleone.pedido.dto.*;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.entity.ItemPedido;
import com.corleone.cliente.entity.Cliente;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.mesa.entity.Mesa;
import com.corleone.cupom.entity.Cupom;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.produto.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PedidoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "funcionario", source = "funcionario")
    @Mapping(target = "mesa", source = "mesa")
    @Mapping(target = "cupom", source = "cupom")
    @Mapping(target = "pagamento", source = "pagamento")
    @Mapping(target = "tipo", source = "request.tipo")
    @Mapping(target = "subtotal", ignore = true)
    @Mapping(target = "desconto", ignore = true)
    @Mapping(target = "taxaEntrega", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "itens", ignore = true)
    @Mapping(target = "historicos", ignore = true)
    Pedido toEntity(PedidoRequest request, Cliente cliente, Funcionario funcionario, Mesa mesa, Cupom cupom, Pagamento pagamento);

}