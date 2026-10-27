package com.example.ciudad_activa1.Repository;

import com.example.ciudad_activa1.Entity.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenciaRepository extends JpaRepository<Evidencia, Long> {
    List<Evidencia> findByReporte_Id(Long reporteId);
    List<Evidencia> findByReporteId(Long reporteId);
}

