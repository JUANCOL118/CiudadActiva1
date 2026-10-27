package com.example.ciudad_activa1.DTO.Request;

import lombok.Data;

@Data
public class ComentarioRequestDTO {
    private String contenido;
    private Long reporteId;
    private Long usuarioId; // Si aplica según tu modelo
}
