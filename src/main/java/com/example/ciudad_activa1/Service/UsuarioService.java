package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.DTO.Response.UsuarioResponseDTO;
import com.example.ciudad_activa1.Entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario registrarUsuario(Usuario usuario, Long rolId);
    List<Usuario> listarTodos();
    Optional<Usuario> buscarPorId(Long id);
    Optional<Usuario> buscarPorCorreo(String correo);
    UsuarioResponseDTO obtenerPorEmail(String email);
}
