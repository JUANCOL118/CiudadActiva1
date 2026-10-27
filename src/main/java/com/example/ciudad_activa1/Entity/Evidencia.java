package com.example.ciudad_activa1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "evidencia")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Evidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String tipo;

    @Column(name = "url_archivo", length = 255)
    private String urlArchivo;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "reporte_id", nullable = false)
    private Reporte reporte;

    @Column(name = "fecha_subida", updatable = false)
    private LocalDateTime fechaSubida;

    @PrePersist
    protected void onCreate(){
        this.fechaSubida = LocalDateTime.now();
    }
}
