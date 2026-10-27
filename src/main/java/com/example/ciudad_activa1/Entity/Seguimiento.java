package com.example.ciudad_activa1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "seguimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "estado_anterior", length = 50 )
    private String estadoAnterior;

    @Column(name = "estado_nuevo", length = 50 )
    private String estadoNuevo;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "reporte_id", nullable = false)
    private Reporte reporte;

    @Column(name = "fecha_cambio", updatable = false)
    private LocalDateTime fechaCambio;

    @PrePersist
    protected void  onCreate(){
        this.fechaCambio = LocalDateTime.now();
    }
}
