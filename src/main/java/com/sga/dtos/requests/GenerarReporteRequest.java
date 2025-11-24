package com.sga.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerarReporteRequest {

    @NotNull
    private Integer estudianteId;

    @Min(1)
    private int semestre;
}
