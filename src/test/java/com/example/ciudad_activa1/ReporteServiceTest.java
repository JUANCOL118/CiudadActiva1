package com.example.ciudad_activa1;

import com.example.ciudad_activa1.DTO.Request.AsignacionRequestDTO;
import com.example.ciudad_activa1.DTO.Request.ValidarReporteRequestDTO;
import com.example.ciudad_activa1.Entity.Reporte;
import com.example.ciudad_activa1.Entity.Rol;
import com.example.ciudad_activa1.Entity.Usuario;
import com.example.ciudad_activa1.Repository.ReporteRepository;
import com.example.ciudad_activa1.Repository.SeguimientoRepository;
import com.example.ciudad_activa1.Repository.UsuarioRepository;
import com.example.ciudad_activa1.Service.Impl.ReporteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReporteServiceTest {

    @Mock
    private ReporteRepository reporteRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private SeguimientoRepository seguimientoRepository;

    @InjectMocks
    private ReporteServiceImpl reporteService;

    private Reporte reporteBase;

    @BeforeEach
    void setUp() {
        reporteBase = new Reporte();
        reporteBase.setId(1L);
        reporteBase.setTitulo("Hueco en la vía");
        reporteBase.setDescripcion("Calle principal");
        reporteBase.setEstado("PENDIENTE");
    }

    @Test
    void test01_ListarTodosLosReportes() {
        when(reporteRepository.findAll()).thenReturn(List.of(reporteBase));
        List<Reporte> lista = reporteService.listarTodos();
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
    }

    @Test
    void test02_BuscarReportePorIdExistente() {
        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));
        Reporte encontrado = reporteService.buscarPorId(1L);
        assertNotNull(encontrado);
        assertEquals(1L, encontrado.getId());
    }

    @Test
    void test03_ValidarReporteAceptadoExitosamente() {
        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));
        when(reporteRepository.save(any(Reporte.class))).thenReturn(reporteBase);

        ValidarReporteRequestDTO dto = new ValidarReporteRequestDTO();
        dto.setEstado("VALIDADO");

        Reporte resultado = reporteService.validarReporte(1L, dto);
        assertEquals("VALIDADO", resultado.getEstado());
    }

    @Test
    void test04_ValidarReporteRechazadoSinObservacionLanzaExcepcion() {
        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));

        ValidarReporteRequestDTO dto = new ValidarReporteRequestDTO();
        dto.setEstado("RECHAZADO");
        dto.setObservacion(""); // Vacío

        assertThrows(IllegalArgumentException.class, () -> reporteService.validarReporte(1L, dto));
    }

    @Test
    void test05_AsignarResponsableExitoso() {
        reporteBase.setEstado("VALIDADO");
        Usuario operador = new Usuario();
        operador.setId(2L);
        Rol rol = new Rol();
        rol.setNombre("OPERADOR");
        operador.setRol(rol);

        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));
        when(usuarioRepository.findById(2L)).thenReturn(Optional.of(operador));
        when(reporteRepository.save(any(Reporte.class))).thenReturn(reporteBase);

        AsignacionRequestDTO dto = new AsignacionRequestDTO();
        dto.setOperadorId(2L);

        Reporte resultado = reporteService.asignarResponsable(1L, dto);
        assertEquals("EN_PROCESO", resultado.getEstado());
        assertEquals(operador, resultado.getOperador());
    }

    @Test
    void test06_AsignarResponsableFallaSiNoEstaValidado() {
        reporteBase.setEstado("PENDIENTE");
        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));

        AsignacionRequestDTO dto = new AsignacionRequestDTO();
        dto.setOperadorId(2L);

        assertThrows(IllegalStateException.class, () -> reporteService.asignarResponsable(1L, dto));
    }

    @Test
    void test07_AsignarResponsableFallaSiUsuarioNoEsOperador() {
        reporteBase.setEstado("VALIDADO");
        Usuario ciudadano = new Usuario();
        ciudadano.setId(3L);
        Rol rol = new Rol();
        rol.setNombre("CIUDADANO"); // No es operador
        ciudadano.setRol(rol);

        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));
        when(usuarioRepository.findById(3L)).thenReturn(Optional.of(ciudadano));

        AsignacionRequestDTO dto = new AsignacionRequestDTO();
        dto.setOperadorId(3L);

        assertThrows(IllegalArgumentException.class, () -> reporteService.asignarResponsable(1L, dto));
    }

    @Test
    void test08_ActualizarReporteExitoso() {
        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));
        when(reporteRepository.save(any(Reporte.class))).thenReturn(reporteBase);

        Reporte modificado = new Reporte();
        modificado.setTitulo("Hueco Reparado");
        modificado.setDescripcion("Arreglado por la alcaldía");

        Reporte resultado = reporteService.actualizarReporte(1L, modificado);
        assertNotNull(resultado);
    }

    @Test
    void test09_ActualizarReporteFallaSiEstaCerrado() {
        reporteBase.setEstado("CERRADO");
        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));

        Reporte modificado = new Reporte();
        modificado.setTitulo("Intento editar");

        assertThrows(IllegalStateException.class, () -> reporteService.actualizarReporte(1L, modificado));
    }

    @Test
    void test10_CerrarReporteExitoso() {
        when(reporteRepository.findById(1L)).thenReturn(Optional.of(reporteBase));
        when(seguimientoRepository.existsByReporte_Id(1L)).thenReturn(true); // <-- Agrega esta línea
        when(reporteRepository.save(any(Reporte.class))).thenReturn(reporteBase);

        Reporte resultado = reporteService.cerrarReporte(1L);
        assertEquals("CERRADO", resultado.getEstado());
    }
}
