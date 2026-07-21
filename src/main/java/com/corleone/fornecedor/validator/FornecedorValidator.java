package com.corleone.fornecedor.validator;

import com.corleone.endereco.entity.Endereco;
import com.corleone.endereco.repository.EnderecoRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.fornecedor.entity.Fornecedor;
import com.corleone.fornecedor.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FornecedorValidator {

    private final FornecedorRepository fornecedorRepository;
    private final EnderecoRepository enderecoRepository;

    public Fornecedor validarFornecedor(Integer id) {

        return fornecedorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.FORNECEDOR_NAO_ENCONTRADO));
    }

    public Endereco validarEndereco(Integer enderecoId) {

        return enderecoRepository.findById(enderecoId).orElseThrow(() -> new BusinessException(ErrorEnum.ENDERECO_NAO_ENCONTRADO));
    }

    public void validarCnpjCadastro(String cnpj) {

        if (fornecedorRepository.existsByForCnpj(cnpj)) {
            throw new BusinessException(ErrorEnum.CNPJ_JA_CADASTRADO);
        }
    }

    public void validarEmailCadastro(String email) {

        if (fornecedorRepository.existsByForEmail(email)) {
            throw new BusinessException(ErrorEnum.EMAIL_JA_CADASTRADO);
        }
    }

    public void validarCnpjAtualizacao(Integer id, String cnpj) {

        fornecedorRepository.findByForCnpj(cnpj)
                .filter(f -> !f.getId().equals(id))
                .ifPresent(f -> {
                    throw new BusinessException(ErrorEnum.CNPJ_JA_CADASTRADO);
                });
    }

    public void validarEmailAtualizacao(Integer id, String email) {

        fornecedorRepository.findByForEmail(email)
                .filter(f -> !f.getId().equals(id))
                .ifPresent(f -> {
                    throw new BusinessException(ErrorEnum.EMAIL_JA_CADASTRADO);
                });
    }

}