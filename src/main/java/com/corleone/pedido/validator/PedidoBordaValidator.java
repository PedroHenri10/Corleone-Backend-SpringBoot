package com.corleone.pedido.validator;

import com.corleone.borda.entity.Borda;
import com.corleone.borda.repository.BordaRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.pedido.entity.ItemPedido;
import com.corleone.pedido.entity.PedidoBorda;
import com.corleone.pedido.repository.PedidoBordaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoBordaValidator {

    private final PedidoBordaRepository repository;
    private final ItemPedidoValidator itemPedidoValidator;
    private final BordaRepository bordaRepository;

    public PedidoBorda validarPedidoBorda(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.PEDIDO_BORDA_NAO_ENCONTRADO));
    }

    public ItemPedido validarItemPedido(Integer id) {
        return itemPedidoValidator.validarItemPedido(id);
    }

    public Borda validarBorda(Integer id) {
        return bordaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.BORDA_NAO_ENCONTRADA));
    }

    public void validarItemPertenceAoPedido(ItemPedido itemPedido, Integer pedidoId) {

        if (itemPedido.getPedido() == null || !itemPedido.getPedido().getId().equals(pedidoId)) {

            throw new BusinessException(ErrorEnum.ITEM_PEDIDO_INVALIDO);
        }
    }
}