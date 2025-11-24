package com.sga.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearUsuarioRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String correo;

    @NotBlank
    private String contrasena;

    @NotNull
    private Integer rolId;
}
