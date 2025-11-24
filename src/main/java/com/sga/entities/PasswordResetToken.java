package com.sga.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "password_reset_tokens")
public class PasswordResetToken {

    @Id
    private Integer id;
    private String token;
    private LocalDateTime fechaExpiracion;
    private boolean usado;

    @DBRef
    private Usuario usuario;

    public static final String SEQUENCE_NAME = "password_token_sequence";
}
