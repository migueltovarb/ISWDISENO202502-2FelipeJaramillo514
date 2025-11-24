package com.sga.controllers;

import com.sga.dtos.CalificacionDto;
import com.sga.dtos.CambioCalificacionDto;
import com.sga.dtos.requests.ActualizarCalificacionRequest;
import com.sga.dtos.requests.CrearCalificacionRequest;
import com.sga.services.CalificacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
@RequiredArgsConstructor
public class CalificacionController {

    private final CalificacionService calificacionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CalificacionDto crear(@Valid @RequestBody CrearCalificacionRequest request) {
        return calificacionService.crear(request);
    }

    @PutMapping
    public CambioCalificacionDto actualizar(@Valid @RequestBody ActualizarCalificacionRequest request) {
        return calificacionService.actualizarNota(request);
    }

    @GetMapping
    public List<CalificacionDto> listar() {
        return calificacionService.listar();
    }
}
