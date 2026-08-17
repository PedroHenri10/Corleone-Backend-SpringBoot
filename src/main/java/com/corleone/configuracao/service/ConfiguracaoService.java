package com.corleone.configuracao.service;

import com.corleone.configuracao.dto.ConfiguracaoRequest;
import com.corleone.configuracao.dto.ConfiguracaoResponse;
import com.corleone.configuracao.dto.ConfiguracaoResumoResponse;
import com.corleone.configuracao.entity.Configuracao;
import com.corleone.configuracao.mapper.ConfiguracaoMapper;
import com.corleone.configuracao.repository.ConfiguracaoRepository;
import com.corleone.configuracao.validator.ConfiguracaoValidator;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ConfiguracaoService {

    private final ConfiguracaoRepository repository;
    private final ConfiguracaoMapper mapper;
    private final ConfiguracaoValidator validator;

    public ConfiguracaoResponse criar(ConfiguracaoRequest request) {

        validator.validarChaveDuplicada(request.getChave());

        Configuracao configuracao = mapper.toEntity(request);

        LocalDateTime agora = LocalDateTime.now(DateUtils.BR_ZONE);

        configuracao.setDataCriacao(agora);
        configuracao.setDataAtualizacao(agora);

        configuracao = repository.save(configuracao);

        return mapper.toResponse(configuracao);
    }

    public ConfiguracaoResponse atualizar(Integer id, ConfiguracaoRequest request) {

        Configuracao configuracao = validator.validarConfiguracao(id);

        validator.validarChaveDuplicada(request.getChave(), id);

        mapper.updateEntity(configuracao, request);

        configuracao.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        configuracao = repository.save(configuracao);

        return mapper.toResponse(configuracao);
    }

    
}