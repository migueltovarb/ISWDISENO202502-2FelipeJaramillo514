package com.sga.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "asignaturas")
public class Asignatura {

    @Id
    private Integer idAsignatura;
    private String codigo;
    private String nombre;
    private int creditos;
    private boolean activa;

    @DBRef
    private Docente docente;

    public static final String SEQUENCE_NAME = "asignatura_sequence";
}
