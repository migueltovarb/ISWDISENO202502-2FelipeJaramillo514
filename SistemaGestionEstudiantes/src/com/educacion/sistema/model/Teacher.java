package com.educacion.sistema.model;

public class Teacher extends Person {
    public Teacher(String id, String nombre, String email) {
        super(id, nombre, email, Role.TEACHER);
    }
}
