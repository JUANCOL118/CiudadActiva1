package com.example.ciudad_activa1.Repository;

import com.example.ciudad_activa1.Entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByReporte_Id(Long reporteId);
}

