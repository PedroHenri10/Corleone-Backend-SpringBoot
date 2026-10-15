package com.corleone.pedido.service;

import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.pedido.dto.HistoricoPedidoRequest;
import com.corleone.pedido.dto.PedidoFilter;
import com.corleone.pedido.dto.PedidoRequest;
import com.corleone.pedido.dto.PedidoResponse;
import com.corleone.pedido.dto.PedidoResumoResponse;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.mapper.PedidoMapper;
import com.corleone.pedido.repository.PedidoRepository;
import com.corleone.pedido.service.HistoricoPedidoService;
import com.corleone.pedido.specification.PedidoSpecification;
import com.corleone.pedido.validator.PedidoValidator;
import com.corleone.shared.enums.StatusPedido;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;
    private final PedidoValidator validator;
    private final HistoricoPedidoService historicoPedidoService;
    private final PedidoRepository pedidoRepository;

    public PedidoResponse criar(PedidoRequest request) {
        var funcionario = validator.validarFuncionario(request.getFuncionarioId());

        var cliente = request.getClienteId() != null
                ? validator.validarCliente(request.getClienteId())
                : null;

        var mesa = request.getMesaId() != null
                ? validator.validarMesa(request.getMesaId())
                : null;

        var cupom = request.getCupomId() != null
                ? validator.validarCupom(request.getCupomId())
                : null;

        var pagamento = request.getPagamentoId() != null
                ? validator.validarPagamento(request.getPagamentoId())
                : null;

        Pedido pedido = mapper.toEntity(
                request, cliente, funcionario, mesa, cupom, pagamento
        );

        LocalDateTime agora = LocalDateTime.now(DateUtils.BR_ZONE);

        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setDataCriacao(agora);
        pedido.setDataAtualizacao(agora);
        pedido.setSubtotal(BigDecimal.ZERO);
        pedido.setDesconto(BigDecimal.ZERO);
        pedido.setTaxaEntrega(BigDecimal.ZERO);
        pedido.setTotal(BigDecimal.ZERO);

        pedido = repository.save(pedido);

        return mapper.toResponse(pedido);
    }

    public PedidoResponse atualizar(Integer id, PedidoRequest request) {
        Pedido pedido = validator.validarPedido(id);
        validator.validarPedidoEditavel(pedido);

        var funcionario = validator.validarFuncionario(request.getFuncionarioId());

        var cliente = request.getClienteId() != null
                ? validator.validarCliente(request.getClienteId())
                : null;

        var mesa = request.getMesaId() != null
                ? validator.validarMesa(request.getMesaId())
                : null;

        var cupom = request.getCupomId() != null
                ? validator.validarCupom(request.getCupomId())
                : null;

        var pagamento = request.getPagamentoId() != null
                ? validator.validarPagamento(request.getPagamentoId())
                : null;

        mapper.updateEntity(
                pedido, request, cliente, funcionario, mesa, cupom, pagamento
        );

        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        pedido = repository.save(pedido);

        return mapper.toResponse(pedido);
    }

    @Transactional(readOnly = true)
    public PedidoResponse buscarPorId(Integer id) {
        return mapper.toResponse(validator.validarPedido(id));
    }

    @Transactional(readOnly = true)
    public Page<PedidoResumoResponse> listar(PedidoFilter filtro, Pageable pageable) {

        return pedidoRepository.findAll(PedidoSpecification.filtro(filtro), pageable).map(mapper::toResumoResponse);
    }

    public PedidoResponse cancelar(Integer id) {
        Pedido pedido = validator.validarPedido(id);
        validator.validarPedidoCancelavel(pedido);

        alterarStatusInterno(pedido, StatusPedido.CANCELADO, null);

        return mapper.toResponse(repository.save(pedido));
    }

    public PedidoResponse finalizar(Integer id) {
        Pedido pedido = validator.validarPedido(id);
        validator.validarPedidoFinalizavel(pedido);

        alterarStatusInterno(pedido, StatusPedido.FINALIZADO, null);

        return mapper.toResponse(repository.save(pedido));
    }

    public PedidoResponse alterarStatus(Integer id, StatusPedido status) {
        Pedido pedido = validator.validarPedido(id);
        validator.validarPedidoEditavel(pedido);

        if (status == null) {
            throw new BusinessException(ErrorEnum.STATUS_PEDIDO_INVALIDO);
        }

        alterarStatusInterno(pedido, status, null);

        return mapper.toResponse(repository.save(pedido));
    }

    private void alterarStatusInterno(
            Pedido pedido,
            StatusPedido novoStatus,
            HistoricoPedidoRequest request
    ) {
        StatusPedido statusAnterior = pedido.getStatus();

        if (statusAnterior == novoStatus) {
            return;
        }

        pedido.setStatus(novoStatus);
        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        HistoricoPedidoRequest historicoRequest = request != null
                ? request
                : HistoricoPedidoRequest.builder().build();

        historicoPedidoService.registrar(
                pedido.getId(),
                historicoRequest,
                statusAnterior != null ? statusAnterior.name() : null,
                novoStatus.name()
        );
    }
}