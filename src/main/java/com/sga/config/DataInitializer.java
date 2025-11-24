package com.sga.config;

import com.sga.entities.Administrador;
import com.sga.entities.Rol;
import com.sga.entities.Usuario;
import com.sga.entities.enums.RolNombre;
import com.sga.repositories.AdministradorRepository;
import com.sga.repositories.RolRepository;
import com.sga.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RolRepository rolRepository;
    private final UsuarioRepository usuarioRepository;
    private final AdministradorRepository administradorRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @PostConstruct
    public void seedData() {
        Rol adminRol = ensureRol(RolNombre.ADMIN, List.of("ALL"));
        Rol docenteRol = ensureRol(RolNombre.DOCENTE, List.of("CALIF_CREAR", "CALIF_EDITAR"));
        Rol estudianteRol = ensureRol(RolNombre.ESTUDIANTE, List.of("NOTAS_VER"));

        Usuario adminUsuario = usuarioRepository.findByUsername("admin")
                .orElseGet(() -> {
                    Usuario nuevo = Usuario.builder()
                            .id(sequenceGeneratorService.generateSequence(Usuario.SEQUENCE_NAME))
                            .nombre("Admin")
                            .apellido("SGA")
                            .username("admin")
                            .correo("admin@sga.com")
                            .contrasena("admin123")
                            .rol(adminRol)
                            .build();
                    return usuarioRepository.save(nuevo);
                });

        boolean adminProfileExists = administradorRepository.findAll().stream()
                .anyMatch(a -> a.getUsuario().getId().equals(adminUsuario.getId()));

        if (!adminProfileExists) {
            Administrador administrador = Administrador.builder()
                    .id(sequenceGeneratorService.generateSequence(Administrador.SEQUENCE_NAME))
                    .usuario(adminUsuario)
                    .build();
            administradorRepository.save(administrador);
        }
    }

    private Rol ensureRol(RolNombre nombre, List<String> permisos) {
        Optional<Rol> existente = rolRepository.findByNombre(nombre);
        if (existente.isPresent()) {
            return existente.get();
        }
        Rol rol = Rol.builder()
                .id(sequenceGeneratorService.generateSequence(Rol.SEQUENCE_NAME))
                .nombre(nombre)
                .permisos(permisos)
                .build();
        return rolRepository.save(rol);
    }
}
