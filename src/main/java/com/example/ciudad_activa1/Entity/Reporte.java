package com.example.ciudad_activa1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reportes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 150)
    private String titulo;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 255)
    private String ubicacion;

    @Column(name = "imagen_url", length = 255)
    private String imagen;

    @Column(nullable = false, length = 50)
    private String estado;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaIncidencia categoriaIncidencia;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(length = 50)
    private String prioridad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudadano_id", nullable = false)
    private Usuario ciudadano;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "operador_id")
    private Usuario operador;

    @PrePersist
    protected void  onCreate(){
        this.fechaCreacion = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = "PENDIENTE";
        }
    }

}
