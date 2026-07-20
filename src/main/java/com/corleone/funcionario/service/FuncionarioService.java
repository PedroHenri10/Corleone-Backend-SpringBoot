package com.corleone.funcionario.service;

import com.corleone.cargo.entity.Cargo;
import com.corleone.endereco.entity.Endereco;
import com.corleone.funcionario.dto.FuncionarioRequest;
import com.corleone.funcionario.dto.FuncionarioResponse;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.mapper.FuncionarioMapper;
import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.funcionario.validator.FuncionarioValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
@Transactional
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper mapper;
    private final FuncionarioValidator validator;

    @Transactional
    public FuncionarioResponse criar(FuncionarioRequest request) {
        String cpfLimpo = request.getCpf() != null ? request.getCpf().replaceAll("\\D", "") : null;
        request.setCpf(cpfLimpo);

        validator.validarCpfCadastro(request.getCpf());
        validator.validarEmailCadastro(request.getEmail());

        Cargo cargo = validator.validarCargo(request.getCargoId());
        Endereco endereco = validator.validarEndereco(request.getEnderecoId());

        Funcionario funcionario = mapper.toEntity(request, cargo, endereco);

        funcionario.setFunAtivo(true);

        funcionario = funcionarioRepository.save(funcionario);
        return mapper.toResponse(funcionario);
    }

    @Transactional
    public FuncionarioResponse atualizar(Integer id, FuncionarioRequest request) {

        Funcionario funcionario = validator.validarFuncionario(id);

        String cpfLimpo = request.getCpf() != null ? request.getCpf().replaceAll("\\D", "") : null;
        request.setCpf(cpfLimpo);

        validator.validarCpfAtualizacao(id, request.getCpf());
        validator.validarEmailAtualizacao(id, request.getEmail());

        Cargo cargo = validator.validarCargo(request.getCargoId());
        Endereco endereco = validator.validarEndereco(request.getEnderecoId());

        mapper.updateEntity(funcionario, request, cargo, endereco);

        funcionario.setFunDtAtualizacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        funcionario = funcionarioRepository.save(funcionario);
        return mapper.toResponse(funcionario);
    }


}
