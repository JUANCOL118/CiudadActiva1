package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.Entity.Evidencia;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EvidenciaService {
    Evidencia guardarEvidencia(MultipartFile file, Long reporteId) throws Exception;;
    List<Evidencia> listarPorReporte(Long reporteId);
}