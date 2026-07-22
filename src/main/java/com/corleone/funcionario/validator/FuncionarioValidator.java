package com.corleone.funcionario.validator;

import com.corleone.cargo.entity.Cargo;
import com.corleone.cargo.repository.CargoRepository;
import com.corleone.endereco.entity.Endereco;
import com.corleone.endereco.repository.EnderecoRepository;
import com.corleone.exception.*;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuncionarioValidator {
    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;
    private final EnderecoRepository enderecoRepository;

    public void validarCpfCadastro(String cpf) {
        if (cpf == null) {
            throw new ResourceNotFoundException(ErrorEnum.REQUEST_INVALIDO);
        }

        String cpfLimpo = cpf.replaceAll("\\D", "");

        if (cpfLimpo.length() != 11) {
            throw new BusinessException(ErrorEnum.CPF_INVALIDO);
        }

        if (funcionarioRepository.existsByFunCpf(cpf)) {
            throw new BusinessException(ErrorEnum.CPF_JA_CADASTRADO);
        }
    }

    public void validarEmailCadastro(String email) {

        if (funcionarioRepository.existsByFunEmail(email)) {
            throw new BusinessException(ErrorEnum.EMAIL_JA_CADASTRADO);
        }
    }

    public void validarCpfAtualizacao(Integer funcionarioId, String cpf) {
        String cpfLimpo = cpf.replaceAll("\\D", "");

        if (cpfLimpo.length() != 11) {
            throw new BusinessException(ErrorEnum.CPF_INVALIDO);
        }

        funcionarioRepository.findByFunCpf(cpfLimpo)
                .ifPresent(funcionario -> {
                    if (!funcionario.getFunId().equals(funcionarioId)) {
                        throw new BusinessException(ErrorEnum.CPF_JA_CADASTRADO);
                    }
                });
    }

    public void validarEmailAtualizacao(Integer funcionarioId, String email) {

        funcionarioRepository.findByFunEmail(email)
                .ifPresent(funcionario -> {
                    if (!funcionario.getFunId().equals(funcionarioId)) {
                        throw new BusinessException(ErrorEnum.EMAIL_JA_CADASTRADO);
                    }
                });
    }

    public Cargo validarCargo(Integer cargoId) {

        Cargo cargo = cargoRepository.findById(cargoId).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.CARGO_NAO_ENCONTRADO));

        if (Boolean.FALSE.equals(cargo.getAtivo())) {
            throw new BusinessException(ErrorEnum.CARGO_INATIVO);
        }

        return cargo;
    }

    public Endereco validarEndereco(Integer enderecoId) {

        if (enderecoId == null) {
            return null;
        }

        return enderecoRepository.findById(enderecoId).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.ENDERECO_NAO_ENCONTRADO));
    }

    public Funcionario validarFuncionario(Integer funcionarioId) {

        return funcionarioRepository.findById(funcionarioId).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.FUNCIONARIO_NAO_ENCONTRADO));
    }
}
