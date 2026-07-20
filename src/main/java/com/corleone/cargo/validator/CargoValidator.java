package com.corleone.cargo.validator;

import com.corleone.cargo.entity.Cargo;
import com.corleone.cargo.repository.CargoRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CargoValidator {

    private final CargoRepository repository;

    public Cargo validarCargo(Integer id) {

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.CARGO_NAO_ENCONTRADO));
    }

    public void validarNomeCadastro(String nome) {

        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new BusinessException(ErrorEnum.CARGO_JA_CADASTRADO);
        }
    }

    public void validarNomeAtualizacao(Integer id, String nome) {

        repository.findByNomeIgnoreCase(nome)
                .filter(c -> !c.getId().equals(id))
                .ifPresent(c -> {
                    throw new BusinessException(ErrorEnum.CARGO_JA_CADASTRADO);
                });
    }

}