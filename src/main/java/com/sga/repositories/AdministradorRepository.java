package com.sga.repositories;

import com.sga.entities.Administrador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdministradorRepository extends MongoRepository<Administrador, Integer> {
}
