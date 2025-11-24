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
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private String username;
    private String correo;
    private String contrasena;

    @DBRef
    private Rol rol;

    public static final String SEQUENCE_NAME = "usuario_sequence";
}
