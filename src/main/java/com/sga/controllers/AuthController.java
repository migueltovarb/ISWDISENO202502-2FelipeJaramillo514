package com.sga.controllers;

import com.sga.dtos.LoginResponse;
import com.sga.dtos.requests.CrearUsuarioRequest;
import com.sga.dtos.requests.LoginRequest;
import com.sga.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public String registrar(@Valid @RequestBody CrearUsuarioRequest request) {
        return authService.registrar(request);
    }

    @PostMapping("/reset/{usuarioId}")
    public String solicitarReset(@PathVariable Integer usuarioId) {
        return authService.solicitarReset(usuarioId);
    }

    @PostMapping("/reset/token/{token}")
    public String consumirReset(@PathVariable String token) {
        return authService.consumirReset(token);
    }
}
