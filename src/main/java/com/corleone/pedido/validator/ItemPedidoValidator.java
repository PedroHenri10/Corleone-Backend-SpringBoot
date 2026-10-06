package com.corleone.pedido.validator;

import com.corleone.pedido.entity.ItemPedido;
import com.corleone.pedido.repository.ItemPedidoRepository;
import com.corleone.produto.entity.Produto;
import com.corleone.produto.repository.ProdutoRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
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

    public Produto validarProduto(Integer id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.PRODUTO_NAO_ENCONTRADO));
    }

   
}