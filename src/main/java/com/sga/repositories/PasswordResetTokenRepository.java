package com.sga.repositories;

import com.sga.entities.PasswordResetToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends MongoRepository<PasswordResetToken, Integer> {
    Optional<PasswordResetToken> findByToken(String token);
}
