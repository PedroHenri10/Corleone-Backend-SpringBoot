
package com.corleone.pedido.service;

import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.pedido.dto.HistoricoPedidoFilter;
import com.corleone.pedido.dto.HistoricoPedidoRequest;
import com.corleone.pedido.dto.HistoricoPedidoResponse;
import com.corleone.pedido.entity.HistoricoPedido;
import com.corleone.pedido.mapper.HistoricoPedidoMapper;
import com.corleone.pedido.repository.HistoricoPedidoRepository;
import com.corleone.pedido.specification.HistoricoPedidoSpecification;
import com.corleone.pedido.validator.PedidoValidator;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoricoPedidoService {

    private final HistoricoPedidoRepository repository;
    private final HistoricoPedidoMapper mapper;
    private final PedidoValidator pedidoValidator;

    
}
