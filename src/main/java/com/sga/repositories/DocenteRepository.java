package com.sga.repositories;

import com.sga.entities.Docente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocenteRepository extends MongoRepository<Docente, Integer> {
}
