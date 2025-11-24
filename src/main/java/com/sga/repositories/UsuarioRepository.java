package com.sga.repositories;

import com.sga.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
    boolean existsByCorreo(String correo);
}
