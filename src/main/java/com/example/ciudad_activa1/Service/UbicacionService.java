package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.Entity.Ubicacion;

import java.util.List;

public interface UbicacionService {
    Ubicacion guardarUbicacion(Ubicacion ubicacion);
    List<Ubicacion> listarUbicaciones();
}
