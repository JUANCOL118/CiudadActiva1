package com.example.ciudad_activa1.Service.Impl;

import com.example.ciudad_activa1.Entity.Evidencia;
import com.example.ciudad_activa1.Entity.Reporte;
import com.example.ciudad_activa1.Repository.EvidenciaRepository;
import com.example.ciudad_activa1.Repository.ReporteRepository;
import com.example.ciudad_activa1.Service.EvidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EvidenciaServiceImpl implements EvidenciaService {

    @Autowired
    private EvidenciaRepository evidenciaRepository;

    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public Evidencia guardarEvidencia(MultipartFile file, Long reporteId) throws Exception {

        Reporte reporte = reporteRepository.findById(reporteId)
                .orElseThrow(() -> new Exception("Reporte no encontrado con ID: " + reporteId));

        String nombreArchivo = file.getOriginalFilename();

        Evidencia evidencia = new Evidencia();
        evidencia.setUrlArchivo(nombreArchivo);
        evidencia.setReporte(reporte);
        return evidenciaRepository.save(evidencia);
    }

    @Override
    public List<Evidencia> listarPorReporte(Long reporteId) {
        // Consultamos las evidencias asociadas a ese reporte específico
        return evidenciaRepository.findByReporteId(reporteId);
    }
}

