package com.sga.controllers;

import com.sga.dtos.AsignaturaDto;
import com.sga.dtos.UsuarioDto;
import com.sga.services.BusquedaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/busqueda")
@RequiredArgsConstructor
public class BusquedaController {

    private final BusquedaService busquedaService;

    @GetMapping("/usuarios")
    public List<UsuarioDto> usuarios(@RequestParam String q) {
        return busquedaService.buscarUsuariosPorNombre(q);
    }

    @GetMapping("/asignaturas")
    public List<AsignaturaDto> asignaturas(@RequestParam String q) {
        return busquedaService.buscarAsignaturas(q);
    }
}
