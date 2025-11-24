package com.sga.repositories;

import com.sga.entities.CambioCalificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CambioCalificacionRepository extends MongoRepository<CambioCalificacion, Integer> {
}
