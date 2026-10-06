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

    
}