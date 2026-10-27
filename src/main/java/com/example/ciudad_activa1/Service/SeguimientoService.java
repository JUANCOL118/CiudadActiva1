package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.DTO.Response.SeguimientoResponseDTO;
import com.example.ciudad_activa1.Entity.Seguimiento;

import java.util.List;

public interface SeguimientoService {
    Seguimiento registarSeguimiento(Seguimiento seguimiento);
    List<Seguimiento> listarPorReporte(Long reporteId);
    SeguimientoResponseDTO guardarSeguimientoParaReporte(Long reporteId, SeguimientoResponseDTO seguimientoResponseDTO);


}