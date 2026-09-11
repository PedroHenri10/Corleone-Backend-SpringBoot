package com.corleone.caixa.service;

import com.corleone.caixa.dto.CaixaFilter;
import com.corleone.caixa.dto.CaixaRequest;
import com.corleone.caixa.dto.CaixaResponse;
import com.corleone.caixa.dto.CaixaResumoResponse;
import com.corleone.caixa.entity.Caixa;
import com.corleone.caixa.entity.LancamentoCaixa;
import com.corleone.caixa.mapper.CaixaMapper;
import com.corleone.caixa.repository.CaixaRepository;
import com.corleone.caixa.specification.CaixaSpecification;
import com.corleone.caixa.validator.CaixaValidator;
import com.corleone.shared.enums.StatusCaixa;
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
public class CaixaService {

    private final CaixaRepository repository;
    private final CaixaMapper mapper;
    private final CaixaValidator validator;

    public CaixaResponse abrir(CaixaRequest request) {

        validator.validarFuncionario(request.getFuncionarioId());

        validator.validarFuncionarioSemCaixaAberto(request.getFuncionarioId());

        validator.validarValorAbertura(request.getValorAbertura());

        var funcionario = validator.validarFuncionario(request.getFuncionarioId());

        Caixa caixa = mapper.toEntity(request, funcionario);

        caixa.setDataAbertura(LocalDateTime.now(DateUtils.BR_ZONE));

        caixa.setStatus(StatusCaixa.ABERTO);

        caixa = repository.save(caixa);

        return mapper.toResponse(caixa);
    }

    @Transactional
    public CaixaResponse fechar(Integer id, BigDecimal valorFechamento
    ) {

        Caixa caixa = validator.validarCaixa(id);

        validator.validarCaixaAberto(caixa);

        validator.validarValorFechamento(valorFechamento);

        BigDecimal valorSistema = caixa.getValorAbertura();

        if (caixa.getLancamentos() != null) {
            for (LancamentoCaixa lancamento : caixa.getLancamentos()) {
                switch (lancamento.getTipo()) {
                    case ENTRADA, SUPRIMENTO ->
                            valorSistema = valorSistema.add(lancamento.getValor());

                    case SAIDA, SANGRIA ->
                            valorSistema = valorSistema.subtract(lancamento.getValor());
                }
            }
        }

        BigDecimal diferenca = valorFechamento.subtract(valorSistema);

        caixa.setValorFechamento(valorFechamento);
        caixa.setValorSistema(valorSistema);
        caixa.setDiferenca(diferenca);

        caixa.setDataFechamento(LocalDateTime.now(DateUtils.BR_ZONE));

        caixa.setStatus(StatusCaixa.FECHADO);

        caixa = repository.save(caixa);

        return mapper.toResponse(caixa);
    }

    @Transactional
    public CaixaResponse buscarPorId(Integer id) {

        Caixa caixa = validator.validarCaixa(id);

        return mapper.toResponse(caixa);
    }

    @Transactional
    public List<CaixaResumoResponse> listar(CaixaFilter filter
    ) {

        return repository
                .findAll(CaixaSpecification.filtro(filter))
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    @Transactional
    public List<CaixaResumoResponse> listarAbertos() {

        return repository
                .findAll(CaixaSpecification.somenteAbertos())
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    private BigDecimal calcularValorSistema(Caixa caixa) {

    }
    }
