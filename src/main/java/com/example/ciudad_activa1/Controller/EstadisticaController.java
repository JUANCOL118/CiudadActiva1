package com.example.ciudad_activa1.Controller;

import com.example.ciudad_activa1.Repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {
    @Autowired
    private ReporteRepository reporteRepository;

    @GetMapping("/reportes")
    public ResponseEntity<Map<String, Object>> obtenerEstadisticasReportes(){
        long totalReportes = reporteRepository.count();
        Map<String, Object> status = new HashMap<>();
        status.put("totalReportes", totalReportes);

        return  ResponseEntity.ok(status);
    }
}

