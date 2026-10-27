package com.example.ciudad_activa1.DTO.Request;

public class ValidarReporteRequestDTO {
    private String estado;
    private String observacion;

    public ValidarReporteRequestDTO() {}

    public ValidarReporteRequestDTO(String estado, String observacion) {
        this.estado = estado;
        this.observacion = observacion;
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }


    public String getJustificacion() { return observacion; }
}

