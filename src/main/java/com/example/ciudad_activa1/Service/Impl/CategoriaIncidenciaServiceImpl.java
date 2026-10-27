package com.example.ciudad_activa1.Service.Impl;

import com.example.ciudad_activa1.Entity.CategoriaIncidencia;
import com.example.ciudad_activa1.Repository.CategoriaIncidenciaRepository;
import com.example.ciudad_activa1.Service.CategoriaIncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaIncidenciaServiceImpl implements CategoriaIncidenciaService {

    @Autowired
    private CategoriaIncidenciaRepository categoriaIncidenciaRepository;

    @Override
    public CategoriaIncidencia crearcategoria(CategoriaIncidencia categoria) {
        return categoriaIncidenciaRepository.save(categoria);
    }

    @Override
    public List<CategoriaIncidencia> listarTodas() {
        return categoriaIncidenciaRepository.findAll();
    }
}
