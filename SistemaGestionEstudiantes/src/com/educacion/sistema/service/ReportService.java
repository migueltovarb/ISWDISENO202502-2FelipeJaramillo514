package com.educacion.sistema.service;

import com.educacion.sistema.model.*;
import com.educacion.sistema.repository.*;
import java.util.*;

public class ReportService {
    private final EnrollmentRepository enrollmentRepository;

    public ReportService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public String generarReporteEstudiante(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte Estudiante: ").append(student.getNombre()).append("\n");
        List<Enrollment> list = enrollmentRepository.findByStudent(student);
        double globalSum = 0; int count = 0;
        for (Enrollment e : list) {
            double avg = e.getAveragePercentage();
            sb.append("Curso ").append(e.getCourse().getCode()).append(" - ").append(e.getCourse().getNombre())
              .append(" Promedio: ").append(String.format(Locale.US, "%.2f", avg)).append("%\n");
            globalSum += avg; count++;
        }
        double global = count == 0 ? 0 : globalSum / count;
        sb.append("Promedio Global: ").append(String.format(Locale.US, "%.2f", global)).append("%\n");
        return sb.toString();
    }

    public String generarReporteCurso(Course course) {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte Curso: ").append(course.getNombre()).append(" ("+course.getCode()+")\n");
        List<Enrollment> list = enrollmentRepository.findByCourse(course);
        double sum = 0; int count = 0; double max = -1; double min = 101; Enrollment top = null; Enrollment low = null;
        for (Enrollment e : list) {
            double avg = e.getAveragePercentage();
            sum += avg; count++;
            if (avg > max) { max = avg; top = e; }
            if (avg < min) { min = avg; low = e; }
        }
        double promedio = count == 0 ? 0 : sum / count;
        sb.append("Promedio Curso: ").append(String.format(Locale.US, "%.2f", promedio)).append("%\n");
        if (top != null) sb.append("Mejor Estudiante: ").append(top.getStudent().getNombre()).append(" ("+String.format(Locale.US, "%.2f", max)+"%)\n");
        if (low != null) sb.append("Estudiante con menor promedio: ").append(low.getStudent().getNombre()).append(" ("+String.format(Locale.US, "%.2f", min)+"%)\n");
        return sb.toString();
    }
}
