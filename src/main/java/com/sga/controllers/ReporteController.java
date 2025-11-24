package com.sga.controllers;

import com.sga.dtos.ReporteDto;
import com.sga.dtos.requests.GenerarReporteRequest;
import com.sga.services.ReporteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReporteDto generar(@Valid @RequestBody GenerarReporteRequest request) {
        return reporteService.generar(request);
    }

    @GetMapping
    public List<ReporteDto> listar() {
        return reporteService.listar();
    }
}
