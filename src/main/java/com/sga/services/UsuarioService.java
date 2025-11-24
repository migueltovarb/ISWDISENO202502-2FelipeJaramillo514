package com.sga.services;

import com.sga.config.SequenceGeneratorService;
import com.sga.dtos.UsuarioDto;
import com.sga.dtos.requests.CrearUsuarioRequest;
import com.sga.entities.Rol;
import com.sga.entities.Usuario;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolService rolService;
    private final SequenceGeneratorService sequenceGeneratorService;

    public UsuarioDto crear(CrearUsuarioRequest request) {
        Rol rol = rolService.obtenerEntidad(request.getRolId());

        Usuario usuario = Usuario.builder()
                .id(sequenceGeneratorService.generateSequence(Usuario.SEQUENCE_NAME))
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .username(request.getUsername())
                .correo(request.getCorreo())
                .contrasena(request.getContrasena())
                .rol(rol)
                .build();

        usuarioRepository.save(usuario);
        return toDto(usuario);
    }

    public List<UsuarioDto> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Usuario obtenerEntidad(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    public UsuarioDto obtener(Integer id) {
        return toDto(obtenerEntidad(id));
    }

    public UsuarioDto buscarPorUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        return toDto(usuario);
    }

    public UsuarioDto mapToDto(Usuario usuario) {
        return UsuarioDto.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .username(usuario.getUsername())
                .correo(usuario.getCorreo())
                .rol(usuario.getRol().getNombre())
                .build();
    }

    private UsuarioDto toDto(Usuario usuario) {
        return mapToDto(usuario);
    }
}
