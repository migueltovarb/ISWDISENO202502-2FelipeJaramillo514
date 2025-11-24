package com.sga.services;

import com.sga.dtos.AsignaturaDto;
import com.sga.dtos.UsuarioDto;
import com.sga.entities.Asignatura;
import com.sga.entities.Usuario;
import com.sga.repositories.AsignaturaRepository;
import com.sga.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusquedaService {

    private final UsuarioRepository usuarioRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final UsuarioService usuarioService;

    public List<UsuarioDto> buscarUsuariosPorNombre(String termino) {
        return usuarioRepository.findAll()
                .stream()
                .filter(u -> u.getNombre() != null && u.getNombre().toLowerCase().contains(termino.toLowerCase()))
                .map(usuarioService::mapToDto)
                .collect(Collectors.toList());
    }

    public List<AsignaturaDto> buscarAsignaturas(String termino) {
        return asignaturaRepository.findAll()
                .stream()
                .filter(a -> a.getNombre() != null && a.getNombre().toLowerCase().contains(termino.toLowerCase()))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private AsignaturaDto toDto(Asignatura asignatura) {
        return AsignaturaDto.builder()
                .idAsignatura(asignatura.getIdAsignatura())
                .codigo(asignatura.getCodigo())
                .nombre(asignatura.getNombre())
                .creditos(asignatura.getCreditos())
                .activa(asignatura.isActiva())
                .docenteId(asignatura.getDocente() != null ? asignatura.getDocente().getId() : null)
                .build();
    }
}
