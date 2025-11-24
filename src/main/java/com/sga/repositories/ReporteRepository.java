package com.sga.repositories;

import com.sga.entities.Reporte;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReporteRepository extends MongoRepository<Reporte, Integer> {
}
