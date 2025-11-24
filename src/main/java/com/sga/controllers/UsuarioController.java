package com.sga.controllers;

import com.sga.dtos.UsuarioDto;
import com.sga.dtos.requests.CrearUsuarioRequest;
import com.sga.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto crear(@Valid @RequestBody CrearUsuarioRequest request) {
        return usuarioService.crear(request);
    }

    @GetMapping
    public List<UsuarioDto> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public UsuarioDto obtener(@PathVariable Integer id) {
        return usuarioService.obtener(id);
    }
}
