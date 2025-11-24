package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.UsuarioDto;
import com.sga.dtos.requests.CrearDocenteRequest;
import com.sga.entities.Docente;
import com.sga.entities.Usuario;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocenteService {

    private final DocenteRepository docenteRepository;
    private final UsuarioService usuarioService;
    private final SequenceGeneratorService sequenceGeneratorService;

    public Docente crear(CrearDocenteRequest request) {
        Usuario usuario = usuarioService.obtenerEntidad(request.getUsuarioId());

        Docente docente = Docente.builder()
                .id(sequenceGeneratorService.generateSequence(Docente.SEQUENCE_NAME))
                .departamento(request.getDepartamento())
                .usuario(usuario)
                .build();

        return docenteRepository.save(docente);
    }

    public Docente obtenerEntidad(Integer id) {
        return docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente no encontrado"));
    }

    public List<UsuarioDto> listarUsuariosDocentes() {
        return docenteRepository.findAll()
                .stream()
                .map(Docente::getUsuario)
                .map(usuarioService::mapToDto)
                .collect(Collectors.toList());
    }
}
