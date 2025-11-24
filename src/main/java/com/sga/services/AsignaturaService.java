package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.AsignaturaDto;
import com.sga.dtos.requests.CrearAsignaturaRequest;
import com.sga.entities.Asignatura;
import com.sga.entities.Docente;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;
    private final DocenteService docenteService;
    private final SequenceGeneratorService sequenceGeneratorService;

    public AsignaturaDto crear(CrearAsignaturaRequest request) {
        Docente docente = docenteService.obtenerEntidad(request.getDocenteId());

        Asignatura asignatura = Asignatura.builder()
                .idAsignatura(sequenceGeneratorService.generateSequence(Asignatura.SEQUENCE_NAME))
                .codigo(request.getCodigo())
                .nombre(request.getNombre())
                .creditos(request.getCreditos())
                .activa(request.isActiva())
                .docente(docente)
                .build();

        asignaturaRepository.save(asignatura);
        return toDto(asignatura);
    }

    public List<AsignaturaDto> listar() {
        return asignaturaRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public Asignatura obtenerEntidad(Integer id) {
        return asignaturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura no encontrada"));
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
