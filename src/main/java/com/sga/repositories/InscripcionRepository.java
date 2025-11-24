package com.sga.repositories;

import com.sga.entities.Inscripcion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InscripcionRepository extends MongoRepository<Inscripcion, Integer> {
}
