package com.corleone.pedido.service;

import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.pedido.mapper.HistoricoPedidoMapper;
import com.corleone.pedido.repository.HistoricoPedidoRepository;
import com.corleone.pedido.validator.PedidoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoricoPedidoService {

    private final HistoricoPedidoRepository repository;
    private final HistoricoPedidoMapper mapper;
    private final PedidoValidator pedidoValidator;
    private final FuncionarioRepository funcionarioRepository;
}
