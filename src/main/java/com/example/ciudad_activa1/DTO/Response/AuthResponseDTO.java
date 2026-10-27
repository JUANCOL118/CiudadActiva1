package com.example.ciudad_activa1.DTO.Response;

public class AuthResponseDTO {
    private String token;
    private Long usuarioId;
    private String nombre;
    private String email;
    private String rol;

    public AuthResponseDTO(){}

    public AuthResponseDTO(String token, Long usuarioId, String nombre, String email, String rol){
        this.token = token;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
