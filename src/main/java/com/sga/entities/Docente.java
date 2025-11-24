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
@Document(collection = "docentes")
public class Docente {

    @Id
    private Integer id;
    private String departamento;

    @DBRef
    private Usuario usuario;

    public static final String SEQUENCE_NAME = "docente_sequence";
}
