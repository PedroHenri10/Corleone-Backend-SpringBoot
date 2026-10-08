package com.corleone.pedido.service;

import com.corleone.pedido.mapper.PedidoMapper;
import com.corleone.pedido.repository.ItemPedidoRepository;
import com.corleone.pedido.validator.ItemPedidoValidator;
import com.corleone.pedido.validator.PedidoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemPedidoService {

    private final ItemPedidoRepository repository;
    private final PedidoMapper mapper;
    private final ItemPedidoValidator validator;
    private final PedidoValidator pedidoValidator;
    
}
