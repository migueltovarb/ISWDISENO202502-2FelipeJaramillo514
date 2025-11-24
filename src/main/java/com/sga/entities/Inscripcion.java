package com.sga.entities;

import com.sga.entities.enums.EstadoInscripcion;
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
@Document(collection = "inscripciones")
public class Inscripcion {

    @Id
    private Integer idInscripcion;
    private int semestre;
    private LocalDate fechaInscripcion;
    private EstadoInscripcion estado;

    @DBRef
    private Estudiante estudiante;

    @DBRef
    private Asignatura asignatura;

    public static final String SEQUENCE_NAME = "inscripcion_sequence";
}
