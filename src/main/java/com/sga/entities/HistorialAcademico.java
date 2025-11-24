package com.sga.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "historiales_academicos")
public class HistorialAcademico {

    @Id
    private Integer idHistorial;
    private double promedioAcumulado;

    @DBRef
    private Estudiante estudiante;

    @DBRef
    private List<Calificacion> calificaciones;

    public static final String SEQUENCE_NAME = "historial_academico_sequence";
}
