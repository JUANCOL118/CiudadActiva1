package com.example.ciudad_activa1.Controller;

import com.example.ciudad_activa1.DTO.Response.SeguimientoResponseDTO;
import com.example.ciudad_activa1.Entity.Seguimiento;
import com.example.ciudad_activa1.Service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguimientos")

public class SeguimientoController {
    @Autowired
    private SeguimientoService seguimientoService;

    @PostMapping
    public ResponseEntity<Seguimiento> registarSeguimiento(@RequestBody Seguimiento seguimiento){
        Seguimiento nuevoSeguimiento = seguimientoService.registarSeguimiento(seguimiento);
        return new ResponseEntity<>(nuevoSeguimiento, HttpStatus.CREATED);
    }

    @GetMapping("/reporte/{reporteId}")
    public ResponseEntity<List<Seguimiento>> listarPorReporte(@PathVariable Long reporteId){
        List<Seguimiento> seguimientos = seguimientoService.listarPorReporte(reporteId);
        return  ResponseEntity.ok(seguimientos);
    }
    @PostMapping("/reportes/{id}/seguimientos")
    public ResponseEntity<SeguimientoResponseDTO> agregarSeguimientoAReporte(
            @PathVariable Long id,
            @RequestBody SeguimientoResponseDTO seguimientoDTO) {

        SeguimientoResponseDTO nuevoSeguimiento = seguimientoService.guardarSeguimientoParaReporte(id, seguimientoDTO);
        return new ResponseEntity<>(nuevoSeguimiento, HttpStatus.CREATED);
    }
}
