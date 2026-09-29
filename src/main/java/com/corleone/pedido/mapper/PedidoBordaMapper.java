package com.corleone.pedido.mapper;

import com.corleone.borda.entity.Borda;
import com.corleone.pedido.dto.PedidoBordaRequest;
import com.corleone.pedido.entity.ItemPedido;
import com.corleone.pedido.entity.PedidoBorda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoBordaMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "itemPedido", source = "itemPedido")
    @Mapping(target = "borda", source = "borda")
    PedidoBorda toEntity(PedidoBordaRequest request, ItemPedido itemPedido, Borda borda);
}
