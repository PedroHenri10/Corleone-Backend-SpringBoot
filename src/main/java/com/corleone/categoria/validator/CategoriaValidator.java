package com.corleone.categoria.validator;

import com.corleone.categoria.entity.Categoria;
import com.corleone.categoria.repository.CategoriaRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriaValidator {

    private final CategoriaRepository categoriaRepository;

    public Categoria validarCategoria(Integer id) {

        return categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.CATEGORIA_NAO_ENCONTRADA));
    }

    public void validarNomeCadastro(String nome) {

        if (categoriaRepository.existsByCatNomeIgnoreCase(nome)) {
            throw new BusinessException(ErrorEnum.CATEGORIA_JA_CADASTRADA);
        }
    }

    public void validarNomeAtualizacao(Integer id, String nome) {

        categoriaRepository
                .findByCatNomeIgnoreCase(nome)
                .filter(categoria -> !categoria.getId().equals(id))
                .ifPresent(categoria -> {
                    throw new BusinessException(ErrorEnum.CATEGORIA_JA_CADASTRADA);
                });
    }
}