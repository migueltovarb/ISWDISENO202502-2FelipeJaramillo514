# Sistema de Gestión de Estudiantes y Notas

Este proyecto implementa un sistema básico para gestionar estudiantes, cursos y calificaciones. Permite:
- Registrar estudiantes y profesores.
- Crear cursos y asignar profesor.
- Matricular estudiantes en cursos.
- Registrar calificaciones de evaluaciones por parte de profesores.
- Consultar reportes de rendimiento por estudiante y por curso.

## Estructura
```
SistemaGestionEstudiantes/
  src/com/educacion/sistema/model/ (Modelos de dominio)
  src/com/educacion/sistema/repository/ (Repositorios en memoria)
  src/com/educacion/sistema/service/ (Servicios de negocio)
  src/com/educacion/sistema/app/ (Aplicación consola)
```

## Ejecutar
Compilar:
```
javac -d out $(dir /s /b src\com\educacion\sistema\*.java)
```
Ejecutar:
```
java -cp out com.educacion.sistema.app.Main
```

## Notas
El almacenamiento es en memoria (HashMaps y Lists). Se puede extender con persistencia real fácilmente.
