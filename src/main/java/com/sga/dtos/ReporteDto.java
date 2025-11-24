package com.sga.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ReporteDto {
    private Integer idReporte;
    private int semestre;
    private LocalDate fechaGeneracion;
    private String rutaArchivoPdf;
    private Integer numeroUnidadesCredito;
    private Integer estudianteId;
    private Integer historialId;
    private List<Integer> calificacionIds;
}
