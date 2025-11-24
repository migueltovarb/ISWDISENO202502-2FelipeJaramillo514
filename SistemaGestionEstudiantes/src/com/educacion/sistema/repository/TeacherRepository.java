package com.educacion.sistema.repository;

import com.educacion.sistema.model.Teacher;
import java.util.*;

public class TeacherRepository {
    private final Map<String, Teacher> data = new HashMap<>();
    public void save(Teacher t) { data.put(t.getId(), t); }
    public Optional<Teacher> findById(String id) { return Optional.ofNullable(data.get(id)); }
    public Collection<Teacher> findAll() { return data.values(); }
}
