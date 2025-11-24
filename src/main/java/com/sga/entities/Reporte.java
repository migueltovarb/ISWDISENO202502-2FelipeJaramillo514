package com.sga.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "reportes")
public class Reporte {

    @Id
    private Integer idReporte;
    private int semestre;
    private LocalDate fechaGeneracion;
    private String rutaArchivoPdf;
    private Integer numeroUnidadesCredito;

    @DBRef
    private Estudiante estudiante;

    @DBRef
    private HistorialAcademico historialAcademico;

    @DBRef
    private List<Calificacion> calificaciones;

    public static final String SEQUENCE_NAME = "reporte_sequence";
}
