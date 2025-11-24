package com.sga.dtos;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class HistorialAcademicoDto {
    private Integer idHistorial;
    private double promedioAcumulado;
    private Integer estudianteId;
    private List<Integer> calificacionIds;
}
