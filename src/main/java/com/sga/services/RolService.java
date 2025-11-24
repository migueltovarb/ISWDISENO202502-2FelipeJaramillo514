package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.RolDto;
import com.sga.dtos.requests.CrearRolRequest;
import com.sga.entities.Rol;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository rolRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public RolDto crear(CrearRolRequest request) {
        Rol rol = Rol.builder()
                .id(sequenceGeneratorService.generateSequence(Rol.SEQUENCE_NAME))
                .nombre(request.getNombre())
                .permisos(request.getPermisos())
                .build();
        rolRepository.save(rol);
        return toDto(rol);
    }

    public List<RolDto> listar() {
        return rolRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Rol obtenerEntidad(Integer id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
    }

    private RolDto toDto(Rol rol) {
        return RolDto.builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .permisos(rol.getPermisos())
                .build();
    }
}
