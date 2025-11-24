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
@Document(collection = "calificaciones")
public class Calificacion {

    @Id
    private Integer idCalificacion;
    private double notaParcial;
    private double notaFinal;
    private String retroalimentacion;
    private LocalDate fechaRegistro;
    private boolean activa;

    @DBRef
    private Inscripcion inscripcion;

    @DBRef
    private Docente docente;

    public static final String SEQUENCE_NAME = "calificacion_sequence";
}
