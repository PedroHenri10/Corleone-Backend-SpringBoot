package com.corleone.funcionario.repository;

import com.corleone.funcionario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FuncionarioRepository extends
        JpaRepository<Funcionario, Integer>,
        JpaSpecificationExecutor<Funcionario> {

    Optional<Funcionario> findByFunCpf(String cpf);

    Optional<Funcionario> findByFunEmail(String email);

    boolean existsByFunCpf(String cpf);

    boolean existsByFunEmail(String email);

}
