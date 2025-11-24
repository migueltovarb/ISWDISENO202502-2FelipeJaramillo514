package com.sga.controllers;

import com.sga.dtos.InscripcionDto;
import com.sga.dtos.requests.CrearInscripcionRequest;
import com.sga.services.InscripcionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {

    private final InscripcionService inscripcionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InscripcionDto crear(@Valid @RequestBody CrearInscripcionRequest request) {
        return inscripcionService.crear(request);
    }

    @GetMapping
    public List<InscripcionDto> listar() {
        return inscripcionService.listar();
    }
}
