package com.educacion.sistema.model;

public class Administrator extends Person {
    public Administrator(String id, String nombre, String email) {
        super(id, nombre, email, Role.ADMIN);
    }
}
