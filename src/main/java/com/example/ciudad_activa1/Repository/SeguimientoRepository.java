package com.example.ciudad_activa1.Repository;

import com.example.ciudad_activa1.Entity.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {
    List<Seguimiento> findByReporte_Id(Long reporteId);

    boolean existsByReporte_Id(Long id);
}
