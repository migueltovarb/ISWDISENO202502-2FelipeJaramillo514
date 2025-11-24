package com.sga.repositories;

import com.sga.entities.Asignatura;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsignaturaRepository extends MongoRepository<Asignatura, Integer> {
}
