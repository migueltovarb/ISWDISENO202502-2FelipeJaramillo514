package com.sga.dtos.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearCalificacionRequest {

    @Min(0)
    @Max(5)
    private double notaParcial;

    @Min(0)
    @Max(5)
    private double notaFinal;

    private String retroalimentacion;

    @NotNull
    private Integer inscripcionId;

    @NotNull
    private Integer docenteId;
}
