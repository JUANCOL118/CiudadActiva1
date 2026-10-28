package com.example.ciudad_activa1.DTO.Request;

public class ReporteRequestDTO {

    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String imagen;
    private String prioridad;
    private Long ciudadanoId;
    private Long categoriaId;

    public ReporteRequestDTO() {
    }

    public ReporteRequestDTO(String titulo, String descripcion, String ubicacion, String imagen, String prioridad, Long ciudadanoId, Long categoriaId) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.prioridad = prioridad;
        this.ciudadanoId = ciudadanoId;
        this.categoriaId = categoriaId;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Long getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(Long ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}