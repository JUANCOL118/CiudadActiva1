package com.example.ciudad_activa1.Service.Impl;

import com.example.ciudad_activa1.DTO.Response.UsuarioResponseDTO;
import com.example.ciudad_activa1.Entity.Rol;
import com.example.ciudad_activa1.Entity.Usuario;
import com.example.ciudad_activa1.Repository.RolRepository;
import com.example.ciudad_activa1.Repository.UsuarioRepository;
import com.example.ciudad_activa1.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private  RolRepository rolRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario, Long rolId) {
        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + rolId));
        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public UsuarioResponseDTO obtenerPorEmail(String email) {
        var usuario = usuarioRepository.findByCorreo(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el correo: " + email));

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
        responseDTO.setId(usuario.getId());
        responseDTO.setNombre(usuario.getNombre());
        responseDTO.setEmail(usuario.getCorreo());

        return responseDTO;
    }
}
