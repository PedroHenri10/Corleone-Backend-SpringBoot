package com.corleone.pedido.validator;

import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.pedido.entity.ItemPedido;
import com.corleone.pedido.repository.ItemPedidoRepository;
import com.corleone.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemPedidoValidator {
    private final ItemPedidoRepository repository;
    private final ProdutoRepository produtoRepository;

    public ItemPedido validarItemPedido(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.ITEM_PEDIDO_NAO_ENCONTRADO));
    }
}
