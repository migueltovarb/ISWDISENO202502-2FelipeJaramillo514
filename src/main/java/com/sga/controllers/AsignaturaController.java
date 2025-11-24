package com.sga.controllers;

import com.sga.dtos.AsignaturaDto;
import com.sga.dtos.requests.CrearAsignaturaRequest;
import com.sga.services.AsignaturaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
@RequiredArgsConstructor
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AsignaturaDto crear(@Valid @RequestBody CrearAsignaturaRequest request) {
        return asignaturaService.crear(request);
    }

    @GetMapping
    public List<AsignaturaDto> listar() {
        return asignaturaService.listar();
    }
}
