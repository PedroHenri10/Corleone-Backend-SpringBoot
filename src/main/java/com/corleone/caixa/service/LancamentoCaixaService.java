package com.corleone.caixa.service;

import com.corleone.caixa.dto.LancamentoCaixaRequest;
import com.corleone.caixa.dto.LancamentoCaixaResponse;
import com.corleone.caixa.entity.LancamentoCaixa;
import com.corleone.caixa.mapper.CaixaMapper;
import com.corleone.caixa.repository.LancamentoCaixaRepository;
import com.corleone.caixa.validator.CaixaValidator;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.pagamento.repository.PagamentoRepository;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.repository.PedidoRepository;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class LancamentoCaixaService {
    private final LancamentoCaixaRepository repository;
    private final CaixaValidator validator;
    private final CaixaMapper mapper;

    private final FuncionarioRepository funcionarioRepository;
    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;

    public LancamentoCaixaResponse criar(LancamentoCaixaRequest request
    ) {

        var caixa = validator.validarCaixa(request.getCaixaId()
        );

        validator.validarLancamentoPermitido(caixa);

        Funcionario funcionario = validator.validarFuncionario(request.getFuncionarioId());

        Pedido pedido = null;

        if (request.getPedidoId() != null) {

            pedido = pedidoRepository.findById(request.getPedidoId()).orElseThrow();
        }

        Pagamento pagamento = null;

        if (request.getPagamentoId() != null) {

            pagamento = pagamentoRepository.findById(request.getPagamentoId()).orElseThrow();
        }

        LancamentoCaixa lancamento = mapper.toEntity(
                        request,
                        caixa,
                        funcionario,
                        pedido,
                        pagamento
                );

        lancamento.setData(LocalDateTime.now(DateUtils.BR_ZONE));

        lancamento = repository.save(lancamento);

        return mapper.toResponse(lancamento);
    }

    
}
