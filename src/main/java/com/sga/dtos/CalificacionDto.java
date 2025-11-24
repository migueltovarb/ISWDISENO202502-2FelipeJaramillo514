package com.sga.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CalificacionDto {
    private Integer idCalificacion;
    private double notaParcial;
    private double notaFinal;
    private String retroalimentacion;
    private LocalDate fechaRegistro;
    private boolean activa;
    private Integer inscripcionId;
    private Integer docenteId;
}
