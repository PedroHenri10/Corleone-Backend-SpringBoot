package com.corleone.security;

import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.usuario.entity.RolePermissao;
import com.corleone.usuario.entity.Usuario;
import com.corleone.usuario.entity.UsuarioRole;
import com.corleone.usuario.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLoginAndAtivoTrue(username).
                orElseThrow( () -> new ResourceNotFoundException(
                        ErrorEnum.USUARIO_NAO_ENCONTRADO)
                );

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (UsuarioRole usuarioRole : usuario.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(usuarioRole.getRole().getNome()));

            for (RolePermissao permissao: usuarioRole.getRole().getPermissoes())
            {
                authorities.add(new SimpleGrantedAuthority(permissao.getPermissao().getNome())
                );
            }
        }

        return
                User.builder().username(usuario.getLogin()).password(usuario.getSenha()).authorities(authorities)
                        .disabled(!usuario.getAtivo()).build();
    }
}
