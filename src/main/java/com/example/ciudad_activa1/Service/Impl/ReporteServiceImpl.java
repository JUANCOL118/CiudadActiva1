package com.example.ciudad_activa1.Service.Impl;

import com.example.ciudad_activa1.DTO.Request.AsignacionRequestDTO;
import com.example.ciudad_activa1.DTO.Request.ReporteRequestDTO;
import com.example.ciudad_activa1.DTO.Request.ValidarReporteRequestDTO;
import com.example.ciudad_activa1.DTO.Response.ReporteResponseDTO;
import com.example.ciudad_activa1.Entity.CategoriaIncidencia;
import com.example.ciudad_activa1.Entity.Reporte;
import com.example.ciudad_activa1.Entity.Usuario;
import com.example.ciudad_activa1.Exception.BusinessRuleException;
import com.example.ciudad_activa1.Exception.ResourceNotFoundException;
import com.example.ciudad_activa1.Repository.CategoriaIncidenciaRepository;
import com.example.ciudad_activa1.Repository.ReporteRepository;
import com.example.ciudad_activa1.Repository.SeguimientoRepository;
import com.example.ciudad_activa1.Repository.UsuarioRepository;
import com.example.ciudad_activa1.Service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaIncidenciaRepository categoriaIncidenciaRepository;

    @Override
    public Reporte registrarReporte(ReporteRequestDTO dto) {
        Reporte reporte = new Reporte();
        reporte.setTitulo(dto.getTitulo());
        reporte.setDescripcion(dto.getDescripcion());
        reporte.setUbicacion(dto.getUbicacion());
        reporte.setImagen(dto.getImagen());
        reporte.setPrioridad(dto.getPrioridad());

        // Buscar la entidad Ciudadano por ID si aplica
        if (dto.getCiudadanoId() != null) {
            // usuarioRepository.findById(dto.getCiudadanoId()).ifPresent(reporte::setCiudadano);
        }

        // Buscar la entidad Categoria por ID si aplica
        if (dto.getCategoriaId() != null) {
            // categoriaRepository.findById(dto.getCategoriaId()).ifPresent(reporte::setCategoria);
        }

        return reporteRepository.save(reporte);
    }

    @Override
    public List<Reporte> listarTodos() {
        return reporteRepository.findAll();
    }

    @Override
    public List<Reporte> obtenerPorCiudadano(Long ciudadanoId) {
        return reporteRepository.findByCiudadano_Id(ciudadanoId);
    }

    @Override
    public Reporte validarReporte(Long id, ValidarReporteRequestDTO dto) {
        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));

        if ("RECHAZADO".equalsIgnoreCase(dto.getEstado())) {
            if (dto.getObservacion() == null || dto.getObservacion().trim().isEmpty()) {
                throw new IllegalArgumentException("El rechazo de un reporte requiere una justificación u observación obligatoria.");
            }
        }

        reporte.setEstado(dto.getEstado().toUpperCase());
        return reporteRepository.save(reporte);
    }

    @Override
    public Reporte cerrarReporte(Long id) {
        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con ID: " + id));

        boolean tieneSeguimientos = seguimientoRepository.existsByReporte_Id(id);
        if (!tieneSeguimientos) {
            throw new BusinessRuleException("No se puede cerrar el reporte porque no tiene al menos un seguimiento registrado.");
        }

        reporte.setEstado("CERRADO");
        return reporteRepository.save(reporte);
    }

    @Override
    public Reporte actualizarReporte(Long id, Reporte reporteDetalles) {
        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));

        if ("CERRADO".equalsIgnoreCase(reporte.getEstado()) || "RESUELTO".equalsIgnoreCase(reporte.getEstado())) {
            throw new IllegalStateException("No se puede editar un reporte que ya se encuentra CERRADO o RESUELTO.");
        }

        reporte.setTitulo(reporteDetalles.getTitulo());
        reporte.setDescripcion(reporteDetalles.getDescripcion());
        return reporteRepository.save(reporte);
    }

    @Override
    public Reporte asignarResponsable(Long reporteId, AsignacionRequestDTO dto) {
        Reporte reporte = reporteRepository.findById(reporteId)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + reporteId));

        if (!"VALIDADO".equalsIgnoreCase(reporte.getEstado())) {
            throw new IllegalStateException("Solo se pueden asignar operadores a reportes en estado VALIDADO.");
        }

        Usuario operador = usuarioRepository.findById(dto.getOperadorId())
                .orElseThrow(() -> new RuntimeException("Usuario operador no encontrado con ID: " + dto.getOperadorId()));

        if (!"OPERADOR".equalsIgnoreCase(operador.getRol().getNombre())) {
            throw new IllegalArgumentException("El usuario asignado debe tener el rol OPERADOR.");
        }

        reporte.setOperador(operador);
        reporte.setEstado("EN_PROCESO");
        return reporteRepository.save(reporte);
    }

    @Override
    public Reporte buscarPorId(Long id) {
        return reporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con ID: " + id));
    }
}

