package com.sga.entities;

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
@Document(collection = "cambios_calificacion")
public class CambioCalificacion {

    @Id
    private Integer idCambio;
    private LocalDate fechaCambio;
    private double valorAnterior;
    private double valorNuevo;
    private String motivo;

    @DBRef
    private Calificacion calificacion;

    @DBRef
    private Administrador administrador;

    public static final String SEQUENCE_NAME = "cambio_calificacion_sequence";
}
