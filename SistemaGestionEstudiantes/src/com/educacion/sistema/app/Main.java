package com.educacion.sistema.app;

import com.educacion.sistema.model.*;
import com.educacion.sistema.repository.*;
import com.educacion.sistema.service.*;

import java.util.*;

public class Main {
    private final StudentRepository studentRepo = new StudentRepository();
    private final TeacherRepository teacherRepo = new TeacherRepository();
    private final CourseRepository courseRepo = new CourseRepository();
    private final EnrollmentRepository enrollmentRepo = new EnrollmentRepository();
    private final EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepo);
    private final GradeService gradeService = new GradeService(enrollmentRepo);
    private final ReportService reportService = new ReportService(enrollmentRepo);
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { new Main().run(); }

    private void run() {
        seedData();
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Sistema Gestión Estudiantes ====");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Registrar Profesor");
            System.out.println("3. Crear Curso");
            System.out.println("4. Matricular Estudiante en Curso");
            System.out.println("5. Registrar Calificación");
            System.out.println("6. Reporte Estudiante");
            System.out.println("7. Reporte Curso");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            String op = scanner.nextLine();
            switch (op) {
                case "1" -> registrarEstudiante();
                case "2" -> registrarProfesor();
                case "3" -> crearCurso();
                case "4" -> matricular();
                case "5" -> registrarCalificacion();
                case "6" -> reporteEstudiante();
                case "7" -> reporteCurso();
                case "0" -> exit = true;
                default -> System.out.println("Opción inválida");
            }
            System.out.println();
        }
    }

    private void seedData() {
        Teacher t = new Teacher("T1", "Docente Inicial", "docente@ejemplo.com");
        teacherRepo.save(t);
        Student s = new Student("S1", "Estudiante Inicial", "estu@ejemplo.com");
        studentRepo.save(s);
        Course c = new Course("CURS1", "Programación", t, 4);
        courseRepo.save(c);
        enrollmentService.matricular(s, c);
    }

    private void registrarEstudiante() {
        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        Student s = new Student(id, nombre, email);
        studentRepo.save(s);
        System.out.println("Estudiante registrado.");
    }

    private void registrarProfesor() {
        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        Teacher t = new Teacher(id, nombre, email);
        teacherRepo.save(t);
        System.out.println("Profesor registrado.");
    }

    private void crearCurso() {
        System.out.print("Código: "); String code = scanner.nextLine();
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Créditos: "); int cred = Integer.parseInt(scanner.nextLine());
        Teacher teacher = elegirProfesor();
        if (teacher == null) { System.out.println("No hay profesor válido."); return; }
        Course c = new Course(code, nombre, teacher, cred);
        courseRepo.save(c);
        System.out.println("Curso creado.");
    }

    private Teacher elegirProfesor() {
        List<Teacher> list = new ArrayList<>(teacherRepo.findAll());
        if (list.isEmpty()) { System.out.println("No hay profesores."); return null; }
        System.out.println("Seleccione profesor:");
        for (int i = 0; i < list.size(); i++) System.out.println((i+1)+". "+list.get(i).getNombre());
        System.out.print("Opción: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= list.size()) return null;
        return list.get(idx);
    }

    private void matricular() {
        Student s = elegirEstudiante();
        Course c = elegirCurso();
        if (s == null || c == null) { System.out.println("Datos inválidos."); return; }
        boolean ok = enrollmentService.matricular(s, c);
        System.out.println(ok ? "Matriculado." : "Ya estaba matriculado.");
    }

    private void registrarCalificacion() {
        Student s = elegirEstudiante();
        Course c = elegirCurso();
        if (s == null || c == null) { System.out.println("Datos inválidos."); return; }
        System.out.print("Nombre Evaluación: "); String nombreEval = scanner.nextLine();
        System.out.print("Puntaje obtenido: "); double score = Double.parseDouble(scanner.nextLine());
        System.out.print("Puntaje máximo: "); double maxScore = Double.parseDouble(scanner.nextLine());
        boolean ok = gradeService.registrarCalificacion(s, c, nombreEval, score, maxScore);
        System.out.println(ok ? "Calificación registrada." : "No matriculado en el curso.");
    }

    private void reporteEstudiante() {
        Student s = elegirEstudiante();
        if (s == null) { System.out.println("Inválido."); return; }
        System.out.println(reportService.generarReporteEstudiante(s));
    }

    private void reporteCurso() {
        Course c = elegirCurso();
        if (c == null) { System.out.println("Inválido."); return; }
        System.out.println(reportService.generarReporteCurso(c));
    }

    private Student elegirEstudiante() {
        List<Student> list = new ArrayList<>(studentRepo.findAll());
        if (list.isEmpty()) { System.out.println("No hay estudiantes."); return null; }
        System.out.println("Seleccione estudiante:");
        for (int i = 0; i < list.size(); i++) System.out.println((i+1)+". "+list.get(i).getNombre());
        System.out.print("Opción: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= list.size()) return null;
        return list.get(idx);
    }

    private Course elegirCurso() {
        List<Course> list = new ArrayList<>(courseRepo.findAll());
        if (list.isEmpty()) { System.out.println("No hay cursos."); return null; }
        System.out.println("Seleccione curso:");
        for (int i = 0; i < list.size(); i++) System.out.println((i+1)+". "+list.get(i).getNombre());
        System.out.print("Opción: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= list.size()) return null;
        return list.get(idx);
    }
}
