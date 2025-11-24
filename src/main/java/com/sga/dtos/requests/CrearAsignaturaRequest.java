package com.sga.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearAsignaturaRequest {

    @NotBlank
    private String codigo;

    @NotBlank
    private String nombre;

    @Min(1)
    private int creditos;

    private boolean activa = true;

    @NotNull
    private Integer docenteId;
}
