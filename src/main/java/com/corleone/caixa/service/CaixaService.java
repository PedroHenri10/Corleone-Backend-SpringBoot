package com.corleone.caixa.service;

import com.corleone.caixa.dto.CaixaRequest;
import com.corleone.caixa.dto.CaixaResponse;
import com.corleone.caixa.entity.Caixa;
import com.corleone.caixa.mapper.CaixaMapper;
import com.corleone.caixa.repository.CaixaRepository;
import com.corleone.caixa.validator.CaixaValidator;
import com.corleone.shared.enums.StatusCaixa;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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

    
}
