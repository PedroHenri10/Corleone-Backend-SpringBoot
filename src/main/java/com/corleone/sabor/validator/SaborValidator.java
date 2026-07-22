package com.corleone.sabor.validator;

import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.sabor.entity.Sabor;
import com.corleone.sabor.repository.SaborRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaborValidator {

    private final SaborRepository repository;

    public Sabor validarSabor(Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new BusinessException(ErrorEnum.SABOR_NAO_ENCONTRADO));
    }

    public void validarNomeCadastro(String nome) {

        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new BusinessException(ErrorEnum.SABOR_JA_CADASTRADO);
        }
    }

    public void validarNomeAtualizacao(Integer id, String nome) {

        if (repository.existsByNomeIgnoreCaseAndIdNot(nome, id)) {
            throw new BusinessException(ErrorEnum.SABOR_JA_CADASTRADO);
        }
    }
}