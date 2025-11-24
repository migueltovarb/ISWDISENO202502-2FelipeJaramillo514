package com.sga.controllers;

import com.sga.dtos.requests.CrearDocenteRequest;
import com.sga.entities.Docente;
import com.sga.services.DocenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
public class DocenteController {

    private final DocenteService docenteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Docente crear(@Valid @RequestBody CrearDocenteRequest request) {
        return docenteService.crear(request);
    }
}
