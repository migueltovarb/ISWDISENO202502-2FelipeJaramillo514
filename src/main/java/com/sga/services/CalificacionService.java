package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.CalificacionDto;
import com.sga.dtos.CambioCalificacionDto;
import com.sga.dtos.requests.ActualizarCalificacionRequest;
import com.sga.dtos.requests.CrearCalificacionRequest;
import com.sga.entities.*;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.CalificacionRepository;
import com.sga.repositories.CambioCalificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;
    private final CambioCalificacionRepository cambioCalificacionRepository;
    private final InscripcionService inscripcionService;
    private final DocenteService docenteService;
    private final AdministradorService administradorService;
    private final SequenceGeneratorService sequenceGeneratorService;

    public CalificacionDto crear(CrearCalificacionRequest request) {
        Inscripcion inscripcion = inscripcionService.obtenerEntidad(request.getInscripcionId());
        Docente docente = docenteService.obtenerEntidad(request.getDocenteId());

        Calificacion calificacion = Calificacion.builder()
                .idCalificacion(sequenceGeneratorService.generateSequence(Calificacion.SEQUENCE_NAME))
                .notaParcial(request.getNotaParcial())
                .notaFinal(request.getNotaFinal())
                .retroalimentacion(request.getRetroalimentacion())
                .fechaRegistro(LocalDate.now())
                .activa(true)
                .inscripcion(inscripcion)
                .docente(docente)
                .build();

        calificacionRepository.save(calificacion);
        return toDto(calificacion);
    }

    public CambioCalificacionDto actualizarNota(ActualizarCalificacionRequest request) {
        Calificacion calificacion = calificacionRepository.findById(request.getCalificacionId())
                .orElseThrow(() -> new ResourceNotFoundException("Calificacion no encontrada"));
        Administrador administrador = administradorService.obtenerEntidad(request.getAdministradorId());

        double anterior = calificacion.getNotaFinal();
        calificacion.setNotaFinal(request.getNotaFinal());
        calificacion.setRetroalimentacion(request.getRetroalimentacion());
        calificacionRepository.save(calificacion);

        CambioCalificacion cambio = CambioCalificacion.builder()
                .idCambio(sequenceGeneratorService.generateSequence(CambioCalificacion.SEQUENCE_NAME))
                .fechaCambio(LocalDate.now())
                .valorAnterior(anterior)
                .valorNuevo(request.getNotaFinal())
                .motivo(request.getRetroalimentacion())
                .calificacion(calificacion)
                .administrador(administrador)
                .build();

        cambioCalificacionRepository.save(cambio);
        return toDto(cambio);
    }

    public List<CalificacionDto> listar() {
        return calificacionRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private CalificacionDto toDto(Calificacion calificacion) {
        return CalificacionDto.builder()
                .idCalificacion(calificacion.getIdCalificacion())
                .notaParcial(calificacion.getNotaParcial())
                .notaFinal(calificacion.getNotaFinal())
                .retroalimentacion(calificacion.getRetroalimentacion())
                .fechaRegistro(calificacion.getFechaRegistro())
                .activa(calificacion.isActiva())
                .inscripcionId(calificacion.getInscripcion() != null ? calificacion.getInscripcion().getIdInscripcion() : null)
                .docenteId(calificacion.getDocente() != null ? calificacion.getDocente().getId() : null)
                .build();
    }

    private CambioCalificacionDto toDto(CambioCalificacion cambioCalificacion) {
        return CambioCalificacionDto.builder()
                .idCambio(cambioCalificacion.getIdCambio())
                .fechaCambio(cambioCalificacion.getFechaCambio())
                .valorAnterior(cambioCalificacion.getValorAnterior())
                .valorNuevo(cambioCalificacion.getValorNuevo())
                .motivo(cambioCalificacion.getMotivo())
                .calificacionId(cambioCalificacion.getCalificacion() != null ? cambioCalificacion.getCalificacion().getIdCalificacion() : null)
                .administradorId(cambioCalificacion.getAdministrador() != null ? cambioCalificacion.getAdministrador().getId() : null)
                .build();
    }
}
