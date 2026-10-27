package com.example.ciudad_activa1.Controller;

import com.example.ciudad_activa1.Service.EvidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/evidencias")
@CrossOrigin(origins = "*")
public class EvidenciaController {

    @Autowired
    private EvidenciaService evidenciaService;

    @GetMapping("/reporte/{reporteId}")
    public ResponseEntity<?> listarPorReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(evidenciaService.listarPorReporte(reporteId));
    }

    // Subir una nueva evidencia multimedia
    @PostMapping("/subir")
    public ResponseEntity<?> subirEvidencia(
            @RequestParam("file") MultipartFile file,
            @RequestParam("reporteId") Long reporteId) {
        try {
            var nuevaEvidencia = evidenciaService.guardarEvidencia(file, reporteId);
            return ResponseEntity.ok(nuevaEvidencia);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al subir la evidencia: " + e.getMessage());
        }
    }
}
