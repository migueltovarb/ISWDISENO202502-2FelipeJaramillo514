package com.educacion.sistema.repository;

import com.educacion.sistema.model.Student;
import java.util.*;

public class StudentRepository {
    private final Map<String, Student> data = new HashMap<>();
    public void save(Student s) { data.put(s.getId(), s); }
    public Optional<Student> findById(String id) { return Optional.ofNullable(data.get(id)); }
    public Collection<Student> findAll() { return data.values(); }
}
