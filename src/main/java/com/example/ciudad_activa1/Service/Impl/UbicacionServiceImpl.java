package com.example.ciudad_activa1.Service.Impl;

import com.example.ciudad_activa1.Entity.Ubicacion;
import com.example.ciudad_activa1.Repository.UbicacionRepository;
import com.example.ciudad_activa1.Service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;
    @Override
    public Ubicacion guardarUbicacion(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public List<Ubicacion> listarUbicaciones() {
        return ubicacionRepository.findAll();
    }
}

