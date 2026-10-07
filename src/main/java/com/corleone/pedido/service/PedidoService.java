package com.corleone.pedido.service;

import com.corleone.pedido.mapper.PedidoMapper;
import com.corleone.pedido.repository.PedidoRepository;
import com.corleone.pedido.validator.PedidoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PedidoService {
    private final PedidoRepository repository;
    private final PedidoMapper mapper;
    private final PedidoValidator validator;
}
