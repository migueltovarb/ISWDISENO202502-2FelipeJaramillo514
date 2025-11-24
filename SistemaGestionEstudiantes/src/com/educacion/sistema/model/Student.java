package com.educacion.sistema.model;

public class Student extends Person {
    public Student(String id, String nombre, String email) {
        super(id, nombre, email, Role.STUDENT);
    }
}
