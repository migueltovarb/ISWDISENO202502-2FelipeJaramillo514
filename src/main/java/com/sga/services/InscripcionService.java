package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.InscripcionDto;
import com.sga.dtos.requests.CrearInscripcionRequest;
import com.sga.entities.Asignatura;
import com.sga.entities.Estudiante;
import com.sga.entities.Inscripcion;
import com.sga.entities.enums.EstadoInscripcion;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.InscripcionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final EstudianteService estudianteService;
    private final AsignaturaService asignaturaService;
    private final SequenceGeneratorService sequenceGeneratorService;

    public InscripcionDto crear(CrearInscripcionRequest request) {
        Estudiante estudiante = estudianteService.obtenerEntidad(request.getEstudianteId());
        Asignatura asignatura = asignaturaService.obtenerEntidad(request.getAsignaturaId());

        Inscripcion inscripcion = Inscripcion.builder()
                .idInscripcion(sequenceGeneratorService.generateSequence(Inscripcion.SEQUENCE_NAME))
                .semestre(request.getSemestre())
                .fechaInscripcion(LocalDate.now())
                .estado(EstadoInscripcion.ACTIVA)
                .estudiante(estudiante)
                .asignatura(asignatura)
                .build();

        inscripcionRepository.save(inscripcion);
        return toDto(inscripcion);
    }

    public List<InscripcionDto> listar() {
        return inscripcionRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public Inscripcion obtenerEntidad(Integer id) {
        return inscripcionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inscripcion no encontrada"));
    }

    private InscripcionDto toDto(Inscripcion inscripcion) {
        return InscripcionDto.builder()
                .idInscripcion(inscripcion.getIdInscripcion())
                .semestre(inscripcion.getSemestre())
                .fechaInscripcion(inscripcion.getFechaInscripcion())
                .estado(inscripcion.getEstado())
                .estudianteId(inscripcion.getEstudiante() != null ? inscripcion.getEstudiante().getId() : null)
                .asignaturaId(inscripcion.getAsignatura() != null ? inscripcion.getAsignatura().getIdAsignatura() : null)
                .build();
    }
}
