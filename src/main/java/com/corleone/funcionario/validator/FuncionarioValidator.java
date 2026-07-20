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
            throw new RegraNegocioException(ErrorEnum.REQUEST_INVALIDO);
        }

        String cpfLimpo = cpf.replaceAll("\\D", "");

        if (cpfLimpo.length() != 11) {
            throw new CpfInvalidoException(ErrorEnum.CPF_INVALIDO);
        }

        if (funcionarioRepository.existsByFunCpf(cpf)) {
            throw new CpfJaCadastradoException(ErrorEnum.CPF_JA_CADASTRADO);
        }
    }

    public void validarEmailCadastro(String email) {

        EmailValidator validator = new EmailValidator();
        if (email == null || !validator.isValid(email, null)) {
            throw new EmailInvalidoException(ErrorEnum.EMAIL_INVALIDO);
        }

        if (funcionarioRepository.existsByFunEmail(email)) {
            throw new EmailJaCadastradoException(ErrorEnum.EMAIL_JA_CADASTRADO);
        }
    }

    public void validarCpfAtualizacao(Integer funcionarioId, String cpf) {
        String cpfLimpo = cpf.replaceAll("\\D", "");

        funcionarioRepository.findByFunCpf(cpfLimpo)
                .ifPresent(funcionario -> {
                    if (!funcionario.getFunId().equals(funcionarioId)) {
                        throw new CpfJaCadastradoException(ErrorEnum.CPF_JA_CADASTRADO);
                    }

                    if (cpfLimpo.length() != 11) {
                        throw new CpfInvalidoException(ErrorEnum.CPF_INVALIDO);
                    }
                });
    }

    public void validarEmailAtualizacao(Integer funcionarioId, String email) {

        String regexEmail = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";

        funcionarioRepository.findByFunEmail(email)
                .ifPresent(funcionario -> {
                    if (!funcionario.getFunId().equals(funcionarioId)) {
                        throw new EmailJaCadastradoException(ErrorEnum.EMAIL_JA_CADASTRADO);
                    }
                    if (email == null || !email.matches(regexEmail)) {
                        throw new EmailInvalidoException(ErrorEnum.EMAIL_INVALIDO);
                    }
                });
    }

    public Cargo validarCargo(Integer cargoId) {

        Cargo cargo = cargoRepository.findById(cargoId)
                .orElseThrow(() ->
                        new CargoNaoEncontradoException(ErrorEnum.CARGO_NAO_ENCONTRADO));

        if (Boolean.FALSE.equals(cargo.getAtivo())) {
            throw new CargoInativoException(ErrorEnum.CARGO_INATIVO);
        }

        return cargo;
    }

    public Endereco validarEndereco(Integer enderecoId) {

        if (enderecoId == null) {
            return null;
        }

        return enderecoRepository.findById(enderecoId)
                .orElseThrow(() ->
                        new EnderecoNaoEncontradoException(ErrorEnum.ENDERECO_NAO_ENCONTRADO));
    }

    public Funcionario validarFuncionario(Integer funcionarioId) {

        return funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() ->
                        new FuncionarioNaoEncontrado(ErrorEnum.FUNCIONARIO_NAO_ENCONTRADO));
    }
}
