package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.DTO.Request.ComentarioRequestDTO;
import com.example.ciudad_activa1.Entity.Comentario;

import java.util.List;

public interface ComentarioService {
    List<Comentario> listarPorReporte(Long reporteId);
    Comentario guardarComentario(ComentarioRequestDTO requestDTO);
}
