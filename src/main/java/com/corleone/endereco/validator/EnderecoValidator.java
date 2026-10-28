package com.corleone.endereco.validator;

import com.corleone.endereco.entity.Endereco;
import com.corleone.endereco.repository.EnderecoRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoValidator {

    private final EnderecoRepository enderecoRepository;

    public Endereco validarEndereco(Integer id) {

        return enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.ENDERECO_NAO_ENCONTRADO));
    }

}