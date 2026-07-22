package com.corleone.tamanho.validator;

import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.tamanho.entity.Tamanho;
import com.corleone.tamanho.repository.TamanhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TamanhoValidator {

    private final TamanhoRepository repository;

    public Tamanho validarTamanho(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.TAMANHO_NAO_ENCONTRADO));
    }

    public void validarNomeCadastro(String nome) {
        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new BusinessException(ErrorEnum.TAMANHO_JA_CADASTRADO);
        }
    }

    public void validarNomeAtualizacao(Integer id, String nome) {
        if (repository.existsByNomeIgnoreCaseAndIdNot(nome, id)) {
            throw new BusinessException(ErrorEnum.TAMANHO_JA_CADASTRADO);
        }
    }

}