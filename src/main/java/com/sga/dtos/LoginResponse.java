package com.sga.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private String mensaje;
    private Integer usuarioId;
    private String rol;
}
