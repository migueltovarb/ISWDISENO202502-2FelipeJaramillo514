package com.sga.repositories;

import com.sga.entities.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, Integer> {
}
