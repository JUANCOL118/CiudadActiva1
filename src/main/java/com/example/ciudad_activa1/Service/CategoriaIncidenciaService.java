package com.example.ciudad_activa1.Service;

import com.example.ciudad_activa1.Entity.CategoriaIncidencia;

import java.util.List;

public interface CategoriaIncidenciaService {
    CategoriaIncidencia crearcategoria(CategoriaIncidencia categoriaIncidencia);
    List<CategoriaIncidencia> listarTodas();
}
