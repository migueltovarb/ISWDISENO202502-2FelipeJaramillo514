package com.sga.dtos;

import com.sga.entities.enums.TipoNotificacion;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class NotificacionDto {
    private Integer id;
    private TipoNotificacion tipo;
    private String mensaje;
    private LocalDate fechaEnvio;
    private boolean leida;
    private Integer usuarioId;
}
