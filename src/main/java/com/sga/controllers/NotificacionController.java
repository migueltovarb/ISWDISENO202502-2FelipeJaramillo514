package com.sga.controllers;

import com.sga.dtos.NotificacionDto;
import com.sga.dtos.requests.CrearNotificacionRequest;
import com.sga.services.NotificacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificacionDto crear(@Valid @RequestBody CrearNotificacionRequest request) {
        return notificacionService.enviar(request);
    }

    @GetMapping
    public List<NotificacionDto> listar() {
        return notificacionService.listar();
    }
}
