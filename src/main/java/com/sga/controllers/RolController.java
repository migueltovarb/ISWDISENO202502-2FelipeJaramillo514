package com.sga.controllers;

import com.sga.dtos.RolDto;
import com.sga.dtos.requests.CrearRolRequest;
import com.sga.services.RolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RolDto crear(@Valid @RequestBody CrearRolRequest request) {
        return rolService.crear(request);
    }

    @GetMapping
    public List<RolDto> listar() {
        return rolService.listar();
    }
}
