package com.corleone.pedido.service;

import com.corleone.pedido.dto.PedidoRequest;
import com.corleone.pedido.dto.PedidoResponse;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.mapper.PedidoMapper;
import com.corleone.pedido.repository.PedidoRepository;
import com.corleone.pedido.validator.PedidoValidator;
import com.corleone.shared.enums.StatusPedido;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class PedidoService {
    private final PedidoRepository repository;
    private final PedidoMapper mapper;
    private final PedidoValidator validator;

    public PedidoResponse criar(PedidoRequest request) {

        var funcionario = validator.validarFuncionario(request.getFuncionarioId());

        var cliente = request.getClienteId() != null ? validator.validarCliente(request.getClienteId()) : null;

        var mesa = request.getMesaId() != null ? validator.validarMesa(request.getMesaId())
                : null;

        var cupom = request.getCupomId() != null ? validator.validarCupom(request.getCupomId()) : null;

        var pagamento = request.getPagamentoId() != null ? validator.validarPagamento(request.getPagamentoId()) : null;

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

    
}
