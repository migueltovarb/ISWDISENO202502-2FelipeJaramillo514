package com.sga.entities;

import com.sga.entities.enums.TipoNotificacion;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "notificaciones")
public class Notificacion {

    @Id
    private Integer id;
    private TipoNotificacion tipo;
    private String mensaje;
    private LocalDate fechaEnvio;
    private boolean leida;

    @DBRef
    private Usuario usuario;

    public static final String SEQUENCE_NAME = "notificacion_sequence";
}
