package com.educacion.sistema.model;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private final Student student;
    private final Course course;
    private final List<GradeRecord> grades = new ArrayList<>();

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public List<GradeRecord> getGrades() { return grades; }
    public void addGrade(GradeRecord gr) { grades.add(gr); }
    public double getAveragePercentage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (GradeRecord g : grades) sum += g.getPercentage();
        return sum / grades.size();
    }
}
