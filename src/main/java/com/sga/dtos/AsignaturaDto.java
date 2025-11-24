package com.sga.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AsignaturaDto {
    private Integer idAsignatura;
    private String codigo;
    private String nombre;
    private int creditos;
    private boolean activa;
    private Integer docenteId;
}
