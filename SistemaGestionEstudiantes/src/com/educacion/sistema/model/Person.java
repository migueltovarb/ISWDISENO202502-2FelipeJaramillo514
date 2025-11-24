package com.educacion.sistema.model;

public abstract class Person {
    protected final String id;
    protected String nombre;
    protected String email;
    protected final Role role;

    protected Person(String id, String nombre, String email, Role role) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.role = role;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public Role getRole() { return role; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
}
