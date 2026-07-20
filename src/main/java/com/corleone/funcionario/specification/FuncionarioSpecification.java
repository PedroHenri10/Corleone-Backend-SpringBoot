package com.corleone.funcionario.specification;

import com.corleone.funcionario.entity.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class FuncionarioSpecification {

    public static Specification<Funcionario> nome(String nome) {

        return (root, query, cb) ->
                nome == null
                        ? null
                        : cb.like(
                        cb.lower(root.get("funNome")),
                        "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Funcionario> cpf(String cpf) {

        return (root, query, cb) ->
                cpf == null
                        ? null
                        : cb.equal(root.get("funCpf"), cpf);
    }

    public static Specification<Funcionario> cargo(Integer cargoId) {

        return (root, query, cb) ->
                cargoId == null
                        ? null
                        : cb.equal(root.get("cargo").get("carId"), cargoId);
    }

    public static Specification<Funcionario> ativo(Boolean ativo) {

        return (root, query, cb) ->
                ativo == null
                        ? null
                        : cb.equal(root.get("funAtivo"), ativo);
    }

    public static Specification<Funcionario> cidade(String cidade) {

        return (root, query, cb) ->
                cidade == null
                        ? null
                        : cb.like(
                        cb.lower(root.get("endereco").get("endCidade")),
                        "%" + cidade.toLowerCase() + "%");
    }

    public static Specification<Funcionario> dataAdmissao(
            LocalDate inicio,
            LocalDate fim) {

        return (root, query, cb) -> {

            if (inicio == null && fim == null) {
                return null;
            }

            if (inicio != null && fim != null) {
                return cb.between(
                        root.get("funDataAdmissao"),
                        inicio,
                        fim);
            }

            if (inicio != null) {
                return cb.greaterThanOrEqualTo(
                        root.get("funDataAdmissao"),
                        inicio);
            }

            return cb.lessThanOrEqualTo(
                    root.get("funDataAdmissao"),
                    fim);
        };
    }

    public static Specification<Funcionario> somenteAtivos() {
        return (root, query, cb) -> cb.isTrue(root.get("funAtivo"));
    }

}