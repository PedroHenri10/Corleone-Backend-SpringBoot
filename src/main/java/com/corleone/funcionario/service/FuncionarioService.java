package com.corleone.funcionario.service;

import com.corleone.cargo.entity.Cargo;
import com.corleone.endereco.entity.Endereco;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.funcionario.dto.FuncionarioFiltro;
import com.corleone.funcionario.dto.FuncionarioRequest;
import com.corleone.funcionario.dto.FuncionarioResponse;
import com.corleone.funcionario.dto.FuncionarioResumoResponse;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.mapper.FuncionarioMapper;
import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.funcionario.specification.FuncionarioSpecification;
import com.corleone.funcionario.validator.FuncionarioValidator;
import com.corleone.shared.util.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


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

        funcionario.setFunDtAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        funcionario = funcionarioRepository.save(funcionario);
        return mapper.toResponse(funcionario);
    }

    @Transactional(readOnly = true)
    public FuncionarioResponse buscarPorId(Integer id) {

        Funcionario funcionario = validator.validarFuncionario(id);

        return mapper.toResponse(funcionario);
    }

    @Transactional(readOnly = true)
    public Page<FuncionarioResumoResponse> listar(
            FuncionarioFiltro filtro,
            Pageable pageable) {

        Specification<Funcionario> specification = montarSpecification(filtro);

        return funcionarioRepository
                .findAll(specification, pageable)
                .map(mapper::toResumoResponse);
    }

    private Specification<Funcionario> montarSpecification(FuncionarioFiltro filtro) {

        return Specification
                .where(
                        filtro.getAtivo() == null
                                ? FuncionarioSpecification.somenteAtivos()
                                : FuncionarioSpecification.ativo(filtro.getAtivo())
                )
                .and(FuncionarioSpecification.nome(filtro.getNome()))
                .and(FuncionarioSpecification.cpf(filtro.getCpf()))
                .and(FuncionarioSpecification.cargo(filtro.getCargoId()))
                .and(FuncionarioSpecification.cidade(filtro.getCidade()))
                .and(
                        FuncionarioSpecification.dataAdmissao(
                                filtro.getDataAdmissaoInicio(),
                                filtro.getDataAdmissaoFim()
                        )
                );
    }

    @Transactional
    public void desativar(Integer id) {

        Funcionario funcionario = validator.validarFuncionario(id);

        if (Boolean.FALSE.equals(funcionario.getFunAtivo())) {
            throw new BusinessException(ErrorEnum.FUNCIONARIO_INATIVO);
        }

        funcionario.setFunAtivo(false);

        funcionarioRepository.save(funcionario);
    }
}
