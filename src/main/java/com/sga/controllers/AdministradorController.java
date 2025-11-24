package com.sga.controllers;

import com.sga.entities.Administrador;
import com.sga.services.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/administradores")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @PostMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador crearDesdeUsuario(@PathVariable Integer usuarioId) {
        return administradorService.crear(usuarioId);
    }
}
