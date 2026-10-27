package com.example.ciudad_activa1.Service.Impl;

import com.example.ciudad_activa1.Entity.Asignacion;
import com.example.ciudad_activa1.Repository.AsignacionRepository;
import com.example.ciudad_activa1.Service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AsignacionServiceImpl implements AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Override
    public Asignacion crearAsignacion(Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

    @Override
    public List<Asignacion> listarPorReporte(Long reporteId) {
        return asignacionRepository.findByReporte_Id(reporteId);
    }

    @Override
    public List<Asignacion> listarPorOperador(Long operadorId) {
        return asignacionRepository.findByOperadorId(operadorId);
    }
}

