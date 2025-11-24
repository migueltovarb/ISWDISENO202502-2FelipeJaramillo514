package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.HistorialAcademicoDto;
import com.sga.entities.Calificacion;
import com.sga.entities.Estudiante;
import com.sga.entities.HistorialAcademico;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.HistorialAcademicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistorialAcademicoService {

    private final HistorialAcademicoRepository historialAcademicoRepository;
    private final EstudianteService estudianteService;
    private final SequenceGeneratorService sequenceGeneratorService;

    public HistorialAcademico crear(Estudiante estudiante, List<Calificacion> calificaciones) {
        double promedio = calificaciones.stream()
                .mapToDouble(Calificacion::getNotaFinal)
                .average()
                .orElse(0.0);

        HistorialAcademico historial = HistorialAcademico.builder()
                .idHistorial(sequenceGeneratorService.generateSequence(HistorialAcademico.SEQUENCE_NAME))
                .promedioAcumulado(promedio)
                .estudiante(estudiante)
                .calificaciones(calificaciones)
                .build();

        return historialAcademicoRepository.save(historial);
    }

    public HistorialAcademico obtenerEntidad(Integer id) {
        return historialAcademicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historial academico no encontrado"));
    }

    public HistorialAcademicoDto toDto(HistorialAcademico historial) {
        List<Integer> ids = historial.getCalificaciones() == null ? List.of() :
                historial.getCalificaciones().stream().map(Calificacion::getIdCalificacion).collect(Collectors.toList());

        return HistorialAcademicoDto.builder()
                .idHistorial(historial.getIdHistorial())
                .promedioAcumulado(historial.getPromedioAcumulado())
                .estudianteId(historial.getEstudiante() != null ? historial.getEstudiante().getId() : null)
                .calificacionIds(ids)
                .build();
    }
}
