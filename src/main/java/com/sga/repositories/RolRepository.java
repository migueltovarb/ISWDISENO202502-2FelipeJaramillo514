package com.sga.repositories;

import com.sga.entities.Rol;
import com.sga.entities.enums.RolNombre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RolRepository extends MongoRepository<Rol, Integer> {
    Optional<Rol> findByNombre(RolNombre nombre);
}
