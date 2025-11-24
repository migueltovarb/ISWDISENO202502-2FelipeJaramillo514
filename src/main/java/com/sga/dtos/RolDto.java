package com.sga.dtos;

import com.sga.entities.enums.RolNombre;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RolDto {
    private Integer id;
    private RolNombre nombre;
    private List<String> permisos;
}
