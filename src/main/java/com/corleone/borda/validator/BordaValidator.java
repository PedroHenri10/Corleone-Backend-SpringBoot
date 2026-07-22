package com.corleone.borda.validator;

import com.corleone.borda.entity.Borda;
import com.corleone.borda.repository.BordaRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BordaValidator {

    private final BordaRepository repository;

    public Borda validarBorda(Integer id) {

        return repository.findById(id).orElseThrow(() -> new BusinessException(ErrorEnum.BORDA_NAO_ENCONTRADA));
    }

    public void validarNomeCadastro(String nome) {

        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new BusinessException(ErrorEnum.BORDA_JA_CADASTRADA);
        }
    }

    public void validarNomeAtualizacao(Integer id, String nome
    ) {

        if (repository.existsByNomeIgnoreCaseAndIdNot(nome, id)) {
            throw new BusinessException(ErrorEnum.BORDA_JA_CADASTRADA);
        }
    }

}