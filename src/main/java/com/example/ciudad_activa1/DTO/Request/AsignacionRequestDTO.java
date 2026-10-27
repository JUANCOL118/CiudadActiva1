package com.example.ciudad_activa1.DTO.Request;

public class AsignacionRequestDTO {
    private Long operadorId;
    private String observacion;

    public AsignacionRequestDTO(){}

    public AsignacionRequestDTO(Long operadorId, String observacion) {
        this.operadorId = operadorId;
        this.observacion = observacion;
    }

    public Long getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Long operadorId) {
        this.operadorId = operadorId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
