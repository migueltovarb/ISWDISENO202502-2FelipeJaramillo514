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
@Document(collection = "administradores")
public class Administrador {

    @Id
    private Integer id;

    @DBRef
    private Usuario usuario;

    public static final String SEQUENCE_NAME = "administrador_sequence";
}
