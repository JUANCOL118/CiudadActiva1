package com.example.ciudad_activa1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "fecha_comentario", updatable = false)
    private LocalDateTime fechaComentario;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "reporte_id", nullable = false)
    private Reporte reporte;

    @PrePersist
    protected void onCreate(){
        this.fechaComentario = LocalDateTime.now();
    }
}

