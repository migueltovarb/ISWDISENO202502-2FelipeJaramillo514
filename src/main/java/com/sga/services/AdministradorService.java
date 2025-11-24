package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.entities.Administrador;
import com.sga.entities.Usuario;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.AdministradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdministradorService {

    private final AdministradorRepository administradorRepository;
    private final UsuarioService usuarioService;
    private final SequenceGeneratorService sequenceGeneratorService;

    public Administrador crear(Integer usuarioId) {
        Usuario usuario = usuarioService.obtenerEntidad(usuarioId);
        Administrador administrador = Administrador.builder()
                .id(sequenceGeneratorService.generateSequence(Administrador.SEQUENCE_NAME))
                .usuario(usuario)
                .build();
        return administradorRepository.save(administrador);
    }

    public Administrador obtenerEntidad(Integer id) {
        return administradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrador no encontrado"));
    }
}
