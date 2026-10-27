package com.example.ciudad_activa1.Repository;

import com.example.ciudad_activa1.Entity.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
    List<Asignacion> findByReporte_Id(Long reproteId);
    List<Asignacion> findByOperadorId(Long operadorId);
}

