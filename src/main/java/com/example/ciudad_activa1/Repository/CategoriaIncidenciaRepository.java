package com.example.ciudad_activa1.Repository;

import com.example.ciudad_activa1.Entity.CategoriaIncidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaIncidenciaRepository extends JpaRepository<CategoriaIncidencia, Long> {
}
