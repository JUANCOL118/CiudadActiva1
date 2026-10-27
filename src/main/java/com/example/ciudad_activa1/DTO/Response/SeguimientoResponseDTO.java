package com.example.ciudad_activa1.DTO.Response;

public class SeguimientoResponseDTO {
    private String nuevoEstado;
    private String observaciones;
    private String evidencia;
    public SeguimientoResponseDTO() {}

    public SeguimientoResponseDTO(String nuevoEstado, String observaciones, String evidencia) {
        this.nuevoEstado = nuevoEstado;
        this.observaciones = observaciones;
        this.evidencia = evidencia;
    }

    public String getNuevoEstado() {
        return nuevoEstado;
    }

    public void setNuevoEstado(String nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String urlEvidencia) {
        this.evidencia = urlEvidencia;
    }
}
