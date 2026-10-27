package com.example.ciudad_activa1.Repository;

import com.example.ciudad_activa1.Entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {

    List<Reporte> findByCiudadano_Id(Long ciudadanoId);
    List<Reporte> findByEstado(String estado);
}
