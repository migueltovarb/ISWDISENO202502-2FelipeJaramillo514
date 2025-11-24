package com.sga.dtos.requests;

import com.sga.entities.enums.RolNombre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CrearRolRequest {

    @NotNull
    private RolNombre nombre;

    @NotEmpty
    private List<String> permisos;
}
