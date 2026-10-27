package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.Entity.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    Rol crearRol(Rol rol);

    List<Rol> listarRoles();

    Optional<Rol> buscarPorNombre(String nombre);
}
