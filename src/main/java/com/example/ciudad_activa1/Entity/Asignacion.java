package com.example.ciudad_activa1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "asignacion")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "reporte_id", nullable = false)
    private Reporte reporte;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "operador_id", nullable = false)
    private Usuario operador;

    @Column(name = "fecha_asignacion", updatable = false)
    private LocalDateTime fechaAsignacion;

    @PrePersist
    protected void onCreate(){
        this.fechaAsignacion = LocalDateTime.now();
    }
}
