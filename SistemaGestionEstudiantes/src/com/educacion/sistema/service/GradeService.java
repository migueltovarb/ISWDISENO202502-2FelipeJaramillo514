package com.educacion.sistema.service;

import com.educacion.sistema.model.*;
import com.educacion.sistema.repository.*;
import java.time.LocalDate;
import java.util.Optional;

public class GradeService {
    private final EnrollmentRepository enrollmentRepository;

    public GradeService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public boolean registrarCalificacion(Student student, Course course, String nombreEval, double score, double maxScore) {
        Optional<Enrollment> opt = enrollmentRepository.findByStudentAndCourse(student, course);
        if (opt.isEmpty()) return false;
        Enrollment e = opt.get();
        e.addGrade(new GradeRecord(nombreEval, score, maxScore, LocalDate.now()));
        return true;
    }
}
