package com.educacion.sistema.repository;

import com.educacion.sistema.model.Course;
import java.util.*;

public class CourseRepository {
    private final Map<String, Course> data = new HashMap<>();
    public void save(Course c) { data.put(c.getCode(), c); }
    public Optional<Course> findByCode(String code) { return Optional.ofNullable(data.get(code)); }
    public Collection<Course> findAll() { return data.values(); }
}
