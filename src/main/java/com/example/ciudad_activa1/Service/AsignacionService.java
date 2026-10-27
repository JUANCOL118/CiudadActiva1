package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.Entity.Asignacion;

import java.util.List;

public interface AsignacionService {
    Asignacion crearAsignacion(Asignacion asignacion);

    List<Asignacion> listarPorReporte(Long reporteId);

    List<Asignacion> listarPorOperador(Long operadorId);
}
