package com.sga.adapters;

import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.time.LocalDateTime;

@Component
public class PdfGeneratorAdapter {

    public String generarRutaTemporal(String prefijo) {
        String timestamp = LocalDateTime.now().toString().replace(":", "-");
        return Paths.get("reportes", prefijo + "-" + timestamp + ".pdf").toString();
    }
}
