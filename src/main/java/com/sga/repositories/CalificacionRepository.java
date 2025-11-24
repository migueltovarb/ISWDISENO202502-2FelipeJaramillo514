package com.sga.repositories;

import com.sga.entities.Calificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalificacionRepository extends MongoRepository<Calificacion, Integer> {
}
