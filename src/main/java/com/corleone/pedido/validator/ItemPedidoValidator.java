package com.corleone.pedido.validator;

import com.corleone.pedido.repository.ItemPedidoRepository;
import com.corleone.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemPedidoValidator {
    private final ItemPedidoRepository repository;
    private final ProdutoRepository produtoRepository;

    
}
