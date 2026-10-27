package com.example.ciudad_activa1.Service.Impl;

import com.example.ciudad_activa1.DTO.Response.SeguimientoResponseDTO;
import com.example.ciudad_activa1.Entity.Reporte;
import com.example.ciudad_activa1.Entity.Seguimiento;
import com.example.ciudad_activa1.Exception.ResourceNotFoundException;
import com.example.ciudad_activa1.Repository.ReporteRepository;
import com.example.ciudad_activa1.Repository.SeguimientoRepository;
import com.example.ciudad_activa1.Service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeguimientoServiceImpl implements SeguimientoService {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public Seguimiento registarSeguimiento(Seguimiento seguimiento) {
        return seguimientoRepository.save(seguimiento);
    }

    @Override
    public List<Seguimiento> listarPorReporte(Long reporteId) {
        return seguimientoRepository.findByReporte_Id(reporteId);
    }

    @Override
    public SeguimientoResponseDTO guardarSeguimientoParaReporte(Long reporteId, SeguimientoResponseDTO seguimientoResponseDTO) {
        Reporte reporte = reporteRepository.findById(reporteId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se puede agregar seguimiento. Reporte no encontrado con ID: " + reporteId));

        Seguimiento seguimiento = new Seguimiento();
        seguimiento.setObservaciones(seguimientoResponseDTO.getObservaciones());
        seguimiento.setReporte(reporte);

        Seguimiento guardado = seguimientoRepository.save(seguimiento);

        return convertirADTO(guardado);
    }

    private SeguimientoResponseDTO convertirADTO(Seguimiento s) {
        SeguimientoResponseDTO dto = new SeguimientoResponseDTO();
        dto.setObservaciones(s.getObservaciones());

        return dto;
    }
}
