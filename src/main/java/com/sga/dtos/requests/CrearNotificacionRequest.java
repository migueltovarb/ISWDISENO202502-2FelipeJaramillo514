package com.sga.dtos.requests;

import com.sga.entities.enums.TipoNotificacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearNotificacionRequest {

    @NotNull
    private TipoNotificacion tipo;

    @NotBlank
    private String mensaje;

    @NotNull
    private Integer usuarioId;
}
