package com.example.ciudad_activa1.Controller;

import com.example.ciudad_activa1.DTO.Request.AsignacionRequestDTO;
import com.example.ciudad_activa1.DTO.Request.ReporteRequestDTO; // <-- Asegúrate de importar el DTO de Request
import com.example.ciudad_activa1.DTO.Request.ValidarReporteRequestDTO;
import com.example.ciudad_activa1.Entity.Reporte;
import com.example.ciudad_activa1.Service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // CORREGIDO: Cambiado de ReporteResponseDTO a ReporteRequestDTO
    @PostMapping
    public ResponseEntity<Reporte> registrarReporte(@RequestBody ReporteRequestDTO dto){
        Reporte nuevoReporte = reporteService.registrarReporte(dto);
        return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reporte>> listarReporte(){
        List<Reporte> reportes = reporteService.listarTodos();
        return ResponseEntity.ok(reportes);
    }

    @GetMapping("/ciudadano/{id}")
    public ResponseEntity<List<Reporte>> obtenerPorCiudadano(@PathVariable Long id){
        List<Reporte> reportes = reporteService.obtenerPorCiudadano(id);
        return ResponseEntity.ok(reportes);
    }

    @PatchMapping("/{id}/validar")
    public ResponseEntity<Reporte> validarReporte(
            @PathVariable Long id,
            @RequestBody ValidarReporteRequestDTO dto) {
        Reporte reporteActualizado = reporteService.validarReporte(id, dto);
        return ResponseEntity.ok(reporteActualizado);
    }

    @PatchMapping("/{id}/cerrar")
    public ResponseEntity<Reporte> cerrarReporte(@PathVariable Long id) {
        Reporte reporteCerrado = reporteService.cerrarReporte(id);
        return ResponseEntity.ok(reporteCerrado);
    }

    @PostMapping("/{id}/asignaciones")
    public ResponseEntity<Reporte> asignarResponsable(
            @PathVariable Long id,
            @RequestBody AsignacionRequestDTO asignacionDTO) {
        Reporte reporteAsignado = reporteService.asignarResponsable(id, asignacionDTO);
        return ResponseEntity.ok(reporteAsignado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> actualizarReporte(
            @PathVariable Long id,
            @RequestBody Reporte reporteDetalles) {
        Reporte reporteActualizado = reporteService.actualizarReporte(id, reporteDetalles);
        return ResponseEntity.ok(reporteActualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerReportePorId(@PathVariable Long id) {
        Reporte reporte = reporteService.buscarPorId(id);
        return ResponseEntity.ok(reporte);
    }
}