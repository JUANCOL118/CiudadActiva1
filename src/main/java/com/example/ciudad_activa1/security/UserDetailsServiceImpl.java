package com.example.ciudad_activa1.security;

import com.example.ciudad_activa1.Entity.Usuario;
import com.example.ciudad_activa1.Repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + correo));

        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getContraseña()) // Usando 'contraseña' con la eñe de tu entidad
                .roles(usuario.getRol() != null ? usuario.getRol().getNombre() : "USER")
                .build();
    }
}
