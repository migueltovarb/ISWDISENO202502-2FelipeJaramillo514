package com.sga.controllers;

import com.sga.dtos.requests.CrearEstudianteRequest;
import com.sga.entities.Estudiante;
import com.sga.services.EstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante crear(@Valid @RequestBody CrearEstudianteRequest request) {
        return estudianteService.crear(request);
    }
}
