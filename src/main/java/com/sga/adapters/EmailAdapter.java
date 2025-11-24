package com.sga.adapters;

import org.springframework.stereotype.Component;

@Component
public class EmailAdapter {

    public void enviarCorreo(String destino, String asunto, String cuerpo) {
        // Stub de integración con SMTP Gateway para alinearse al diagrama de componentes.
        System.out.printf("Enviando correo a %s: %s%n", destino, asunto);
    }
}
