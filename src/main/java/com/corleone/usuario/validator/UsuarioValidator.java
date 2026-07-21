package com.corleone.usuario.validator;

import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.usuario.entity.Role;
import com.corleone.usuario.entity.Usuario;
import com.corleone.usuario.repository.RoleRepository;
import com.corleone.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioValidator {

    private final UsuarioRepository usuarioRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final RoleRepository roleRepository;

    public Usuario validarUsuario(Integer id) {

        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.USUARIO_NAO_ENCONTRADO));
    }

    public Funcionario validarFuncionario(Integer id) {

        return funcionarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.FUNCIONARIO_NAO_ENCONTRADO));
    }

    public void validarLoginCadastro(String login) {

        if (usuarioRepository.existsByLogin(login)) {
            throw new BusinessException(ErrorEnum.LOGIN_JA_CADASTRADO);
        }
    }

    public void validarLoginAtualizacao(Integer id, String login) {

        if (usuarioRepository.existsByLoginAndIdNot(login, id)) {
            throw new BusinessException(ErrorEnum.LOGIN_JA_CADASTRADO);
        }
    }

    public List<Role> validarRoles(List<Integer> ids) {

        List<Role> roles = roleRepository.findByIdIn(ids);

        if (roles.size() != ids.size()) {
            throw new ResourceNotFoundException(ErrorEnum.ROLE_NAO_ENCONTRADA);
        }

        return roles;
    }

}