package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.DTO.Request.AsignacionRequestDTO;
import com.example.ciudad_activa1.DTO.Request.ReporteRequestDTO;
import com.example.ciudad_activa1.DTO.Request.ValidarReporteRequestDTO;
import com.example.ciudad_activa1.DTO.Response.ReporteResponseDTO;
import com.example.ciudad_activa1.Entity.Reporte;

import java.util.List;

public interface ReporteService {
    Reporte registrarReporte(ReporteRequestDTO dto);    List<Reporte> listarTodos();
    List<Reporte> obtenerPorCiudadano(Long ciudadanoId);

    Reporte validarReporte(Long id, ValidarReporteRequestDTO dto);

    Reporte cerrarReporte(Long id);
    Reporte actualizarReporte(Long id, Reporte reporteDetalles);
    Reporte asignarResponsable(Long reporteId, AsignacionRequestDTO dto);
    Reporte buscarPorId(Long id);
}
