package com.example.ciudad_activa1.DTO.Response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class ReporteResponseDTO {

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotBlank(message = "La ubicacion es obligatoria")
    private String ubicacion;

    private String imagen;

    private String prioridad;

    @NotNull(message = "El ID del ciudadano es obligatorio")
    private Long ciudadanoId;

    @NotNull(message = "El ID de la categoria es obligatoria")
    private Long categoriaId;
}

