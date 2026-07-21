package com.corleone.usuario.mapper;

import com.corleone.funcionario.entity.Funcionario;
import com.corleone.usuario.dto.UsuarioRequest;
import com.corleone.usuario.dto.UsuarioResponse;
import com.corleone.usuario.dto.UsuarioResumoResponse;
import com.corleone.usuario.entity.Usuario;
import com.corleone.usuario.entity.UsuarioRole;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ultimoAcesso", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "ativo", constant = "true")
    @Mapping(target = "funcionario", source = "funcionario")
    @Mapping(target = "roles", ignore = true)
    Usuario toEntity(UsuarioRequest request, Funcionario funcionario);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "funcionarioId", source = "funcionario.funId")
    @Mapping(target = "funcionarioNome", source = "funcionario.funNome")
    @Mapping(target = "roles", expression = "java(mapRoles(usuario.getRoles()))")
    UsuarioResponse toResponse(Usuario usuario);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "funcionario", source = "funcionario.funNome")
    @Mapping(target = "ativo", source = "ativo")
    UsuarioResumoResponse toResumoResponse(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ultimoAcesso", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "funcionario", source = "funcionario")
    void updateEntity(@MappingTarget Usuario usuario, UsuarioRequest request, Funcionario funcionario);

    default List<String> mapRoles(List<UsuarioRole> usuarioRoles) {

        if (usuarioRoles == null) {
            return List.of();
        }

        return usuarioRoles.stream()
                .map(ur -> ur.getRole().getNome())
                .toList();
    }
}