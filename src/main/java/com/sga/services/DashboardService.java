package com.sga.services;

import com.sga.repositories.AsignaturaRepository;
import com.sga.repositories.CalificacionRepository;
import com.sga.repositories.EstudianteRepository;
import com.sga.repositories.InscripcionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final EstudianteRepository estudianteRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final InscripcionRepository inscripcionRepository;
    private final CalificacionRepository calificacionRepository;

    public ResumenDashboard obtenerResumen() {
        return new ResumenDashboard(
                estudianteRepository.count(),
                asignaturaRepository.count(),
                inscripcionRepository.count(),
                calificacionRepository.count()
        );
    }

    @Getter
    public static class ResumenDashboard {
        private final long estudiantes;
        private final long asignaturas;
        private final long inscripciones;
        private final long calificaciones;

        public ResumenDashboard(long estudiantes, long asignaturas, long inscripciones, long calificaciones) {
            this.estudiantes = estudiantes;
            this.asignaturas = asignaturas;
            this.inscripciones = inscripciones;
            this.calificaciones = calificaciones;
        }
    }
}
