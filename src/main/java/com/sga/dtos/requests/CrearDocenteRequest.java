package com.sga.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearDocenteRequest {
    @NotBlank
    private String departamento;

    @NotNull
    private Integer usuarioId;
}
