package com.sga.repositories;

import com.sga.entities.HistorialAcademico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistorialAcademicoRepository extends MongoRepository<HistorialAcademico, Integer> {
}
