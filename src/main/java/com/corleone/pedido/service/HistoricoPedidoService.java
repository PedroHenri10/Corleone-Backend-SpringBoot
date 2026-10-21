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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public HistoricoPedidoResponse registrar(
            Integer pedidoId,
            HistoricoPedidoRequest request,
            String statusAnterior,
            String statusNovo
    ) {
        var pedido = pedidoValidator.validarPedido(pedidoId);

        var funcionario = request.getFuncionarioId() != null
                ? pedidoValidator.validarFuncionario(request.getFuncionarioId())
                : null;

        HistoricoPedido historico = mapper.toEntity(
                request,
                pedido,
                funcionario,
                statusAnterior,
                statusNovo
        );

        historico.setData(LocalDateTime.now(DateUtils.BR_ZONE));

        historico = repository.save(historico);

        return mapper.toResponse(historico);
    }

    @Transactional(readOnly = true)
    public HistoricoPedidoResponse buscarPorId(Integer id) {
        HistoricoPedido historico = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                ErrorEnum.RECURSO_NAO_ENCONTRADO
                        )
                );

        return mapper.toResponse(historico);
    }

    @Transactional(readOnly = true)
    public Page<HistoricoPedidoResponse> listar(HistoricoPedidoFilter filtro, Pageable pageable
    ) {
        return repository.findAll(HistoricoPedidoSpecification.filtro(filtro), pageable).map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    public List<HistoricoPedidoResponse> listarPorPedido(Integer pedidoId) {
        pedidoValidator.validarPedido(pedidoId);

        return repository.findByPedidoId(pedidoId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}