package com.sga.repositories;

import com.sga.entities.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacionRepository extends MongoRepository<Notificacion, Integer> {
}
