package com.sga.services;

import com.sga.dtos.LoginResponse;
import com.sga.dtos.requests.CrearUsuarioRequest;
import com.sga.dtos.requests.LoginRequest;
import com.sga.entities.PasswordResetToken;
import com.sga.entities.Usuario;
import com.sga.exception.ResourceNotFoundException;
import com.sga.repositories.PasswordResetTokenRepository;
import com.sga.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final com.sga.config.SequenceGeneratorService sequenceGeneratorService;

    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                .filter(u -> u.getContrasena().equals(request.getContrasena()))
                .orElseThrow(() -> new com.sga.exception.UnauthorizedException("Credenciales invalidas"));

        return new LoginResponse("Acceso concedido", usuario.getId(), usuario.getRol().getNombre().name());
    }

    public String registrar(CrearUsuarioRequest request) {
        usuarioService.crear(request);
        return "Usuario registrado";
    }

    public String solicitarReset(Integer usuarioId) {
        Usuario usuario = usuarioService.obtenerEntidad(usuarioId);
        PasswordResetToken token = PasswordResetToken.builder()
                .id(sequenceGeneratorService.generateSequence(PasswordResetToken.SEQUENCE_NAME))
                .token(UUID.randomUUID().toString())
                .fechaExpiracion(LocalDateTime.now().plusHours(2))
                .usado(false)
                .usuario(usuario)
                .build();
        passwordResetTokenRepository.save(token);
        return token.getToken();
    }

    public String consumirReset(String token) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("Token no valido"));
        resetToken.setUsado(true);
        passwordResetTokenRepository.save(resetToken);
        return "Token consumido";
    }
}
