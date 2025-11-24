package com.sga.services;

import com.sga.adapters.PdfGeneratorAdapter;
import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.ReporteDto;
import com.sga.dtos.requests.GenerarReporteRequest;
import com.sga.entities.Calificacion;
import com.sga.entities.Estudiante;
import com.sga.entities.HistorialAcademico;
import com.sga.entities.Reporte;
import com.sga.repositories.CalificacionRepository;
import com.sga.repositories.ReporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final ReporteRepository reporteRepository;
    private final EstudianteService estudianteService;
    private final CalificacionRepository calificacionRepository;
    private final HistorialAcademicoService historialAcademicoService;
    private final PdfGeneratorAdapter pdfGeneratorAdapter;
    private final SequenceGeneratorService sequenceGeneratorService;

    public ReporteDto generar(GenerarReporteRequest request) {
        Estudiante estudiante = estudianteService.obtenerEntidad(request.getEstudianteId());

        List<Calificacion> calificaciones = calificacionRepository.findAll().stream()
                .filter(c -> c.getInscripcion() != null && c.getInscripcion().getEstudiante() != null)
                .filter(c -> c.getInscripcion().getEstudiante().getId().equals(estudiante.getId()))
                .collect(Collectors.toList());

        HistorialAcademico historial = historialAcademicoService.crear(estudiante, calificaciones);

        Reporte reporte = Reporte.builder()
                .idReporte(sequenceGeneratorService.generateSequence(Reporte.SEQUENCE_NAME))
                .semestre(request.getSemestre())
                .fechaGeneracion(LocalDate.now())
                .rutaArchivoPdf(pdfGeneratorAdapter.generarRutaTemporal("reporte-est-" + estudiante.getId()))
                .numeroUnidadesCredito(calcularUnidadesCredito(calificaciones))
                .estudiante(estudiante)
                .historialAcademico(historial)
                .calificaciones(calificaciones)
                .build();

        reporteRepository.save(reporte);
        return toDto(reporte);
    }

    public List<ReporteDto> listar() {
        return reporteRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private ReporteDto toDto(Reporte reporte) {
        List<Integer> calificacionIds = reporte.getCalificaciones() == null ? List.of() :
                reporte.getCalificaciones().stream().map(Calificacion::getIdCalificacion).collect(Collectors.toList());

        return ReporteDto.builder()
                .idReporte(reporte.getIdReporte())
                .semestre(reporte.getSemestre())
                .fechaGeneracion(reporte.getFechaGeneracion())
                .rutaArchivoPdf(reporte.getRutaArchivoPdf())
                .numeroUnidadesCredito(reporte.getNumeroUnidadesCredito())
                .estudianteId(reporte.getEstudiante() != null ? reporte.getEstudiante().getId() : null)
                .historialId(reporte.getHistorialAcademico() != null ? reporte.getHistorialAcademico().getIdHistorial() : null)
                .calificacionIds(calificacionIds)
                .build();
    }

    private int calcularUnidadesCredito(List<Calificacion> calificaciones) {
        return calificaciones.stream()
                .map(c -> c.getInscripcion() != null && c.getInscripcion().getAsignatura() != null
                        ? c.getInscripcion().getAsignatura().getCreditos() : 0)
                .reduce(0, Integer::sum);
    }
}
