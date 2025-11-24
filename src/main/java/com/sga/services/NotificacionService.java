package com.sga.services;

import com.sga.dtos.NotificacionDto;
import com.sga.dtos.requests.CrearNotificacionRequest;
import com.sga.adapters.EmailAdapter;
import com.sga.config.SequenceGeneratorService;
import com.sga.entities.Notificacion;
import com.sga.entities.Usuario;
import com.sga.repositories.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private final UsuarioService usuarioService;
    private final EmailAdapter emailAdapter;
    private final SequenceGeneratorService sequenceGeneratorService;

    public NotificacionDto enviar(CrearNotificacionRequest request) {
        Usuario usuario = usuarioService.obtenerEntidad(request.getUsuarioId());

        Notificacion notificacion = Notificacion.builder()
                .id(sequenceGeneratorService.generateSequence(Notificacion.SEQUENCE_NAME))
                .tipo(request.getTipo())
                .mensaje(request.getMensaje())
                .fechaEnvio(LocalDate.now())
                .leida(false)
                .usuario(usuario)
                .build();

        notificacionRepository.save(notificacion);
        emailAdapter.enviarCorreo(usuario.getCorreo(), "Nueva notificacion", request.getMensaje());
        return toDto(notificacion);
    }

    public List<NotificacionDto> listar() {
        return notificacionRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private NotificacionDto toDto(Notificacion notificacion) {
        return NotificacionDto.builder()
                .id(notificacion.getId())
                .tipo(notificacion.getTipo())
                .mensaje(notificacion.getMensaje())
                .fechaEnvio(notificacion.getFechaEnvio())
                .leida(notificacion.isLeida())
                .usuarioId(notificacion.getUsuario() != null ? notificacion.getUsuario().getId() : null)
                .build();
    }
}
