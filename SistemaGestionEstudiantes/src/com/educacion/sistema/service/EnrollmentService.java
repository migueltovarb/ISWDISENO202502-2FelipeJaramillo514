package com.educacion.sistema.service;

import com.educacion.sistema.model.*;
import com.educacion.sistema.repository.*;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public boolean matricular(Student s, Course c) {
        if (enrollmentRepository.findByStudentAndCourse(s, c).isPresent()) return false;
        enrollmentRepository.save(new Enrollment(s, c));
        return true;
    }
}
