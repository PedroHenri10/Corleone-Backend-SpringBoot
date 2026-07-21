package com.corleone.usuario.service;

import com.corleone.funcionario.entity.Funcionario;
import com.corleone.shared.util.DateUtils;
import com.corleone.usuario.dto.*;
import com.corleone.usuario.entity.Role;
import com.corleone.usuario.entity.Usuario;
import com.corleone.usuario.entity.UsuarioRole;
import com.corleone.usuario.mapper.UsuarioMapper;
import com.corleone.usuario.repository.UsuarioRepository;
import com.corleone.usuario.repository.UsuarioRoleRepository;
import com.corleone.usuario.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioRoleRepository usuarioRoleRepository;
    private final UsuarioMapper mapper;
    private final UsuarioValidator validator;
    private final PasswordEncoder passwordEncoder;

    public UsuarioResponse criar(UsuarioRequest request) {

        validator.validarLoginCadastro(request.getLogin());

        Funcionario funcionario = validator.validarFuncionario(request.getFuncionarioId());

        List<Role> roles = validator.validarRoles(request.getRoles());

        Usuario usuario = mapper.toEntity(request, funcionario);

        usuario.setSenha(passwordEncoder.encode(request.getSenha()));

        usuario.setAtivo(true);

        usuario = usuarioRepository.save(usuario);

        salvarRoles(usuario, roles);

        return mapper.toResponse(usuario);
    }

    public UsuarioResponse atualizar(Integer id, UsuarioRequest request) {

        Usuario usuario = validator.validarUsuario(id);

        validator.validarLoginAtualizacao(id, request.getLogin());

        Funcionario funcionario = validator.validarFuncionario(request.getFuncionarioId());

        List<Role> roles = validator.validarRoles(request.getRoles());

        mapper.updateEntity(usuario, request, funcionario);

        if (request.getSenha() != null && !request.getSenha().isBlank()) {
            usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        }

        usuario.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        usuarioRoleRepository.deleteByUsuario(usuario);

        usuario = usuarioRepository.save(usuario);

        salvarRoles(usuario, roles);

        return mapper.toResponse(usuario);
    }

    @Transactional(readOnly = true)
    public UsuarioResponse buscarPorId(Integer id) {

        return mapper.toResponse(validator.validarUsuario(id));
    }

    @Transactional(readOnly = true)
    public Page<UsuarioResumoResponse> listar(Pageable pageable) {

        return usuarioRepository.findAll(pageable).map(mapper::toResumoResponse);
    }

    public void desativar(Integer id) {

        Usuario usuario = validator.validarUsuario(id);

        usuario.setAtivo(false);

        usuarioRepository.save(usuario);
    }

    private void salvarRoles(Usuario usuario, List<Role> roles) {

        List<UsuarioRole> usuarioRoles =
                roles.stream()
                        .map(role ->
                                UsuarioRole.builder()
                                        .usuario(usuario)
                                        .role(role)
                                        .dataCriacao(LocalDateTime.now(DateUtils.BR_ZONE))
                                        .build())
                        .toList();

        usuarioRoleRepository.saveAll(usuarioRoles);
    }

}