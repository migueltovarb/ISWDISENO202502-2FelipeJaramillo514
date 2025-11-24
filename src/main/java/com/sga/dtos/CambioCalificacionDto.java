package com.sga.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CambioCalificacionDto {
    private Integer idCambio;
    private LocalDate fechaCambio;
    private double valorAnterior;
    private double valorNuevo;
    private String motivo;
    private Integer calificacionId;
    private Integer administradorId;
}
