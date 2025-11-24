## SGA Backend - Endpoints clave

Base URL: `http://localhost:8080`

### Flujo mínimo (solo lo solicitado)
1) **Roles y usuarios**
   - Crear roles: `POST /api/roles`
     ```json
     { "nombre": "ADMIN", "permisos": ["ALL"] }
     ```
   - Registrar usuarios: `POST /api/auth/registro`
     ```json
     {
       "nombre": "Luis",
       "apellido": "Perez",
       "username": "lperez",
       "correo": "luis.perez@x.com",
       "contrasena": "segura123",
       "rolId": 1
     }
     ```
   - Login: `POST /api/auth/login`
     ```json
     { "username": "admin", "contrasena": "admin123" }
     ```

2) **Perfiles**
   - Crear docente: `POST /api/docentes`
     ```json
     { "departamento": "Matematicas", "usuarioId": 3 }
     ```
   - Crear estudiante: `POST C`
     ```json
     {
       "programa": "Ing",
       "semestre": 1,
       "usuarioId": 4
     }
     ```

3) **Oferta académica**
   - Crear asignatura: `POST /api/asignaturas`
     ```json
     {
       "codigo": "MAT101",
       "nombre": "Calculo",
       "creditos": 3,
       "activa": true,
       "docenteId": 1
     }
     ```

4) **Inscripciones**
   - Crear inscripción: `POST /api/inscripciones`
     ```json
     { "semestre": 1, "estudianteId": 1, "asignaturaId": 1 }
     ```

5) **Profesores registran calificaciones**
   - Crear calificación: `POST /api/calificaciones`
     ```json
     {
       "notaParcial": 4.0,
       "notaFinal": 4.5,
       "retroalimentacion": "Buen trabajo",
       "inscripcionId": 1,
       "docenteId": 1
     }
     ```

6) **Estudiantes consultan notas**
   - Listar calificaciones: `GET /api/calificaciones` (filtra en el cliente por su inscripción/asignatura).
   - Listar inscripciones: `GET /api/inscripciones`

7) **Administradores generan reportes**
   - Generar reporte: `POST /api/reportes`
     ```json
     { "estudianteId": 1, "semestre": 1 }
     ```
   - Listar reportes: `GET /api/reportes`
   - Dashboard general: `GET /api/dashboard`

### Ejecución rápida
1. Asegura acceso a Mongo (URI ya configurada en `application.properties`).
2. Arranca: `mvnw.cmd spring-boot:run` (Windows) o `./mvnw spring-boot:run` (Unix).
