package com.sga.entities;

import com.sga.entities.enums.RolNombre;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "roles")
public class Rol {

    @Id
    private Integer id;
    private RolNombre nombre;
    private List<String> permisos;

    public static final String SEQUENCE_NAME = "rol_sequence";
}
