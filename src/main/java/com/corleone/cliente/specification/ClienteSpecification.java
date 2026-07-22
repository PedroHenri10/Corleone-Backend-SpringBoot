package com.corleone.cliente.specification;

import com.corleone.cliente.entity.Cliente;
import org.springframework.data.jpa.domain.Specification;

public class ClienteSpecification {

    public static Specification<Cliente> nome(String nome) {

        return (root, query, cb) ->
                nome == null
                        ? null
                        : cb.like(
                        cb.lower(root.get("nome")),
                        "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Cliente> telefone(String telefone) {

        return (root, query, cb) ->
                telefone == null
                        ? null
                        : cb.like(
                        cb.lower(root.get("telefone1")),
                        "%" + telefone.toLowerCase() + "%");
    }

    public static Specification<Cliente> email(String email) {

        return (root, query, cb) ->
                email == null
                        ? null
                        : cb.equal(
                        cb.lower(root.get("email")),
                        email.toLowerCase());
    }

    public static Specification<Cliente> status(String status) {

        return (root, query, cb) ->
                status == null
                        ? null
                        : cb.equal(
                        cb.lower(root.get("status")),
                        status.toLowerCase());
    }

    public static Specification<Cliente> cidade(String cidade) {

        return (root, query, cb) ->
                cidade == null
                        ? null
                        : cb.like(
                        cb.lower(root.get("endereco").get("endCidade")),
                        "%" + cidade.toLowerCase() + "%");
    }

    public static Specification<Cliente> ativo(Boolean ativo) {

        return (root, query, cb) ->
                ativo == null
                        ? null
                        : cb.equal(root.get("ativo"), ativo);
    }

    public static Specification<Cliente> somenteAtivos() {

        return (root, query, cb) ->
                cb.isTrue(root.get("ativo"));
    }

}