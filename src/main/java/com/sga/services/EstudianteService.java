package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.UsuarioDto;
import com.sga.dtos.requests.CrearEstudianteRequest;
import com.sga.entities.Estudiante;
import com.sga.entities.Usuario;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final UsuarioService usuarioService;
    private final SequenceGeneratorService sequenceGeneratorService;

    public Estudiante crear(CrearEstudianteRequest request) {
        Usuario usuario = usuarioService.obtenerEntidad(request.getUsuarioId());

        Estudiante estudiante = Estudiante.builder()
                .id(sequenceGeneratorService.generateSequence(Estudiante.SEQUENCE_NAME))
                .programa(request.getPrograma())
                .semestre(request.getSemestre())
                .usuario(usuario)
                .build();

        return estudianteRepository.save(estudiante);
    }

    public Estudiante obtenerEntidad(Integer id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));
    }

    public List<UsuarioDto> listarUsuariosEstudiantes() {
        return estudianteRepository.findAll()
                .stream()
                .map(Estudiante::getUsuario)
                .map(usuarioService::mapToDto)
                .collect(Collectors.toList());
    }
}
