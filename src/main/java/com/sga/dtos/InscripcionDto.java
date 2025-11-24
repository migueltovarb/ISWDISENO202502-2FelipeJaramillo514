package com.sga.dtos;

import com.sga.entities.enums.EstadoInscripcion;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class InscripcionDto {
    private Integer idInscripcion;
    private int semestre;
    private LocalDate fechaInscripcion;
    private EstadoInscripcion estado;
    private Integer estudianteId;
    private Integer asignaturaId;
}
