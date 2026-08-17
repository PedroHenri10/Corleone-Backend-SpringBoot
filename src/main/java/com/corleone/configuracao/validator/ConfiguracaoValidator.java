package com.corleone.configuracao.validator;

import com.corleone.configuracao.entity.Configuracao;
import com.corleone.configuracao.repository.ConfiguracaoRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConfiguracaoValidator {

    private final ConfiguracaoRepository repository;

    public Configuracao validarConfiguracao(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.CONFIGURACAO_NAO_ENCONTRADA));
    }

    public Configuracao validarChave(String chave) {
        return repository.findByChave(chave).orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.CONFIGURACAO_NAO_ENCONTRADA));
    }

    
}