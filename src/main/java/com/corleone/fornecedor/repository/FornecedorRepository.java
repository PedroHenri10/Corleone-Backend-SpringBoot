package com.corleone.fornecedor.repository;

import com.corleone.fornecedor.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>, JpaSpecificationExecutor<Fornecedor> {

    Optional<Fornecedor> findByForCnpj(String cnpj);

    Optional<Fornecedor> findByForEmail(String email);

    boolean existsByForCnpj(String cnpj);

    boolean existsByForEmail(String email);

    boolean existsByForCnpjAndIdNot(String cnpj, Integer id);

    boolean existsByForEmailAndIdNot(String email, Integer id);
}
