package com.sga.dtos;

import com.sga.entities.enums.RolNombre;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UsuarioDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String username;
    private String correo;
    private RolNombre rol;
}
