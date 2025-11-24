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
@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private Integer id;
    private String programa;
    private int semestre;

    @DBRef
    private Usuario usuario;

    public static final String SEQUENCE_NAME = "estudiante_sequence";
}
