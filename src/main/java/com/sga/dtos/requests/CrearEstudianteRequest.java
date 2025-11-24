package com.sga.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearEstudianteRequest {

    @NotBlank
    private String programa;

    @Min(1)
    private int semestre;

    @NotNull
    private Integer usuarioId;
}
