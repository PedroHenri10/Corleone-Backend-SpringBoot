package com.corleone.funcionario.mapper;

import com.corleone.cargo.entity.Cargo;
import com.corleone.endereco.entity.Endereco;
import com.corleone.funcionario.dto.FuncionarioRequest;
import com.corleone.funcionario.dto.FuncionarioResponse;
import com.corleone.funcionario.dto.FuncionarioResumoResponse;
import com.corleone.funcionario.entity.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FuncionarioMapper {

    @Mapping(target = "funId", ignore = true)
    @Mapping(target = "funDtCriacao", ignore = true)
    @Mapping(target = "funDtAtualizacao", ignore = true)

    @Mapping(target = "funNome", source = "request.nome")
    @Mapping(target = "funCpf", source = "request.cpf")
    @Mapping(target = "funRg", source = "request.rg")
    @Mapping(target = "funDataNascimento", source = "request.dataNascimento")
    @Mapping(target = "funTelefone", source = "request.telefone")
    @Mapping(target = "funEmail", source = "request.email")
    @Mapping(target = "funSalario", source = "request.salario")
    @Mapping(target = "funDataAdmissao", source = "request.dataAdmissao")
    @Mapping(target = "funDataDemissao", source = "request.dataDemissao")
    @Mapping(target = "funAtivo", constant = "true")
    @Mapping(target = "cargo", source = "cargo")
    @Mapping(target = "endereco", source = "endereco")
    Funcionario toEntity(FuncionarioRequest request, Cargo cargo, Endereco endereco);

    @Mapping(target = "id", source = "funId")
    @Mapping(target = "nome", source = "funNome")
    @Mapping(target = "cpf", source = "funCpf")
    @Mapping(target = "rg", source = "funRg")
    @Mapping(target = "dataNascimento", source = "funDataNascimento")
    @Mapping(target = "telefone", source = "funTelefone")
    @Mapping(target = "email", source = "funEmail")
    @Mapping(target = "salario", source = "funSalario")
    @Mapping(target = "dataAdmissao", source = "funDataAdmissao")
    @Mapping(target = "dataDemissao", source = "funDataDemissao")
    @Mapping(target = "ativo", source = "funAtivo")
    @Mapping(target = "dataCriacao", source = "funDtCriacao")
    @Mapping(target = "dataAtualizacao", source = "funDtAtualizacao")
    @Mapping(target = "cargoId", source = "cargo.carId")
    @Mapping(target = "cargoNome", source = "cargo.carNome")
    @Mapping(target = "enderecoId", source = "endereco.endId")
    FuncionarioResponse toResponse(Funcionario funcionario);

    @Mapping(target = "id", source = "funId")
    @Mapping(target = "nome", source = "funNome")
    @Mapping(target = "cpf", source = "funCpf")
    @Mapping(target = "cargo", source = "cargo.carNome")
    @Mapping(target = "ativo", source = "funAtivo")
    FuncionarioResumoResponse toResumoResponse(Funcionario funcionario);

    @Mapping(target = "funId", ignore = true)
    @Mapping(target = "funDtCriacao", ignore = true)
    @Mapping(target = "funDtAtualizacao", ignore = true)
    @Mapping(target = "funAtivo", ignore = true)

    @Mapping(target = "funNome", source = "request.nome")
    @Mapping(target = "funCpf", source = "request.cpf")
    @Mapping(target = "funRg", source = "request.rg")
    @Mapping(target = "funDataNascimento", source = "request.dataNascimento")
    @Mapping(target = "funTelefone", source = "request.telefone")
    @Mapping(target = "funEmail", source = "request.email")
    @Mapping(target = "funSalario", source = "request.salario")
    @Mapping(target = "funDataAdmissao", source = "request.dataAdmissao")
    @Mapping(target = "funDataDemissao", source = "request.dataDemissao")
    @Mapping(target = "cargo", source = "cargo")
    @Mapping(target = "endereco", source = "endereco")
    void updateEntity(@MappingTarget Funcionario funcionario, FuncionarioRequest request, Cargo cargo, Endereco endereco);

}