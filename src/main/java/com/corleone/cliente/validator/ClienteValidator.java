package com.corleone.cliente.validator;

import com.corleone.cliente.entity.Cliente;
import com.corleone.cliente.repository.ClienteRepository;
import com.corleone.endereco.entity.Endereco;
import com.corleone.endereco.validator.EnderecoValidator;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteValidator {

    private final ClienteRepository repository;
    private final EnderecoValidator enderecoValidator;

    public Cliente validarCliente(Integer id) {

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.CLIENTE_NAO_ENCONTRADO));
    }

    public void validarEmailCadastro(String email) {

        if (repository.existsByEmail(email)) {
            throw new BusinessException(ErrorEnum.EMAIL_JA_CADASTRADO);
        }
    }

    public void validarEmailAtualizacao(Integer id, String email) {

        if (repository.existsByEmailAndIdNot(email, id)) {
            throw new BusinessException(ErrorEnum.EMAIL_JA_CADASTRADO);
        }
    }

    public Endereco validarEndereco(Integer enderecoId) {

        return enderecoValidator.validarEndereco(enderecoId);
    }

}