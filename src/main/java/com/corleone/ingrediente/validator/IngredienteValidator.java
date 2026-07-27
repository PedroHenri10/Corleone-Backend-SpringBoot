package com.corleone.ingrediente.validator;

import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.ingrediente.entity.Ingrediente;
import com.corleone.ingrediente.repository.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredienteValidator {

    private final IngredienteRepository repository;

    public Ingrediente validarIngrediente(Integer id) {

        return repository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.INGREDIENTE_NAO_ENCONTRADO));
    }

    public void validarNomeCadastro(String nome) {

        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new BusinessException(ErrorEnum.INGREDIENTE_JA_CADASTRADO);
        }
    }

    public void validarNomeAtualizacao(Integer id, String nome) {

        if (repository.existsByNomeIgnoreCaseAndIdNot(nome, id)) {
            throw new BusinessException(ErrorEnum.INGREDIENTE_JA_CADASTRADO);
        }
    }

}