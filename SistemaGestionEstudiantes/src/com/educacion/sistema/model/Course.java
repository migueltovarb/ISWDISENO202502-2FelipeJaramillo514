package com.educacion.sistema.model;

public class Course {
    private final String code;
    private String nombre;
    private Teacher teacher;
    private int creditos;

    public Course(String code, String nombre, Teacher teacher, int creditos) {
        this.code = code;
        this.nombre = nombre;
        this.teacher = teacher;
        this.creditos = creditos;
    }

    public String getCode() { return code; }
    public String getNombre() { return nombre; }
    public Teacher getTeacher() { return teacher; }
    public int getCreditos() { return creditos; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
}
