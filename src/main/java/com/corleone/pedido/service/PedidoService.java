package com.corleone.pedido.service;

import com.corleone.pedido.dto.PedidoFilter;
import com.corleone.pedido.dto.PedidoRequest;
import com.corleone.pedido.dto.PedidoResponse;
import com.corleone.pedido.dto.PedidoResumoResponse;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.mapper.PedidoMapper;
import com.corleone.pedido.repository.PedidoRepository;
import com.corleone.pedido.specification.PedidoSpecification;
import com.corleone.pedido.validator.PedidoValidator;
import com.corleone.shared.enums.StatusPedido;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
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
                request,
                cliente,
                funcionario,
                mesa,
                cupom,
                pagamento
        );

        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setDataCriacao(LocalDateTime.now(DateUtils.BR_ZONE));
        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

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
                pedido,
                request,
                cliente,
                funcionario,
                mesa,
                cupom,
                pagamento
        );

        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        pedido = repository.save(pedido);

        return mapper.toResponse(pedido);
    }

    @Transactional(readOnly = true)
    public PedidoResponse buscarPorId(Integer id) {

        Pedido pedido = validator.validarPedido(id);

        return mapper.toResponse(pedido);
    }

    @Transactional(readOnly = true)
    public List<PedidoResumoResponse> listar(PedidoFilter filter) {

        return repository.findAll(PedidoSpecification.filtro(filter))
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public PedidoResponse cancelar(Integer id) {

        Pedido pedido = validator.validarPedido(id);
        validator.validarPedidoCancelavel(pedido);

        pedido.setStatus(StatusPedido.CANCELADO);
        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        pedido = repository.save(pedido);

        return mapper.toResponse(pedido);
    }

    public PedidoResponse finalizar(Integer id) {

        Pedido pedido = validator.validarPedido(id);
        validator.validarPedidoFinalizavel(pedido);

        pedido.setStatus(StatusPedido.FINALIZADO);
        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        pedido = repository.save(pedido);

        return mapper.toResponse(pedido);
    }

    public PedidoResponse alterarStatus(Integer id, StatusPedido status) {

        Pedido pedido = validator.validarPedido(id);
        validator.validarPedidoEditavel(pedido);

        pedido.setStatus(status);
        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        pedido = repository.save(pedido);

        return mapper.toResponse(pedido);
    }
}