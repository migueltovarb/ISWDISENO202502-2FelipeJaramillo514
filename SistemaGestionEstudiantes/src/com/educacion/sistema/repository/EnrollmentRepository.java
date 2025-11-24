package com.educacion.sistema.repository;

import com.educacion.sistema.model.Enrollment;
import com.educacion.sistema.model.Student;
import com.educacion.sistema.model.Course;
import java.util.*;

public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();
    public void save(Enrollment e) { enrollments.add(e); }
    public List<Enrollment> findByStudent(Student s) {
        List<Enrollment> list = new ArrayList<>();
        for (Enrollment e : enrollments) if (e.getStudent().equals(s)) list.add(e);
        return list;
    }
    public Optional<Enrollment> findByStudentAndCourse(Student s, Course c) {
        for (Enrollment e : enrollments) if (e.getStudent().equals(s) && e.getCourse().equals(c)) return Optional.of(e);
        return Optional.empty();
    }
    public List<Enrollment> findByCourse(Course c) {
        List<Enrollment> list = new ArrayList<>();
        for (Enrollment e : enrollments) if (e.getCourse().equals(c)) list.add(e);
        return list;
    }
    public List<Enrollment> findAll() { return Collections.unmodifiableList(enrollments); }
}
