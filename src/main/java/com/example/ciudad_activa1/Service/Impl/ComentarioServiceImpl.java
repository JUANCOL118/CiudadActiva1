package com.example.ciudad_activa1.Service.Impl;

import com.example.ciudad_activa1.DTO.Request.ComentarioRequestDTO;
import com.example.ciudad_activa1.Entity.Comentario;
import com.example.ciudad_activa1.Entity.Reporte;
import com.example.ciudad_activa1.Repository.ComentarioRepository;
import com.example.ciudad_activa1.Repository.ReporteRepository;
import com.example.ciudad_activa1.Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ReporteRepository reporteRepository; // <-- Faltaba esta línea

    @Override
    public List<Comentario> listarPorReporte(Long reporteId) {
        return comentarioRepository.findByReporte_Id(reporteId);
    }

    @Override
    public Comentario guardarComentario(ComentarioRequestDTO requestDTO) {
        Reporte reporte = reporteRepository.findById(requestDTO.getReporteId())
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + requestDTO.getReporteId()));

        Comentario comentario = new Comentario();
        comentario.setContenido(requestDTO.getContenido());
        comentario.setReporte(reporte);

        return comentarioRepository.save(comentario);
    }
}
