package com.example.ciudad_activa1.Controller;

import com.example.ciudad_activa1.Service.ComentarioService;
import com.example.ciudad_activa1.DTO.Request.ComentarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "*")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Listar comentarios de un reporte
    @GetMapping("/reporte/{reporteId}")
    public ResponseEntity<?> listarPorReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(comentarioService.listarPorReporte(reporteId));
    }

    // Crear un nuevo comentario usando RequestDTO
    @PostMapping
    public ResponseEntity<?> crearComentario(@RequestBody ComentarioRequestDTO comentarioRequestDTO) {
        var nuevoComentario = comentarioService.guardarComentario(comentarioRequestDTO);
        return ResponseEntity.ok(nuevoComentario);
    }
}
