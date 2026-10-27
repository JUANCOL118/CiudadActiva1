package com.example.ciudad_activa1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="categorias_incidencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaIncidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, unique = true, length = 100)
    private  String nombre;

    @Column(length = 255)
    private  String description;
}

